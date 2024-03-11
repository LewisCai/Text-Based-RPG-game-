package game.unarmed;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Status;
import game.action.attackactions.AttackAction;
import game.enemy.Enemy;
import game.enemy.EnemyCapabilities;

/**
 * Pile of bones Actor class
 *
 * Created by:
 * @author Jun Choi
 * @version Updated as of 2/05/23
 */
public class PileOfBoneActor extends Enemy {

    /**
     * An instance of the skeleton class that died
     */
    private final Actor skeleton;

    /**
     * Counter for checking if 3 turns have passed
     */
    private int playCount = 0;

    /**
     * Constructor.
     *
     */
    public PileOfBoneActor(Actor actor) {
        super("Pile of Bones", 'X', 1);
        this.addCapability(EnemyCapabilities.DEATH_PASSIVE);
        this.skeleton = actor;

    }

    /**
     * Through each turn, if the pile of bones are not hit by any other actor, the playcount is incremented,
     * when this reaches 3, the pile of bones will be replaced by a healed instance of the skeleton actor that
     * previously died. If another actor is able to hit the pile of bones before 3 turns, this will instead return a
     * death action.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return Death action or Do nothing action depending on if it was hit
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display){
        playCount += 1;
        Location boneLocation = map.locationOf(this);
        int x = boneLocation.x();
        int y = boneLocation.y();
        if (playCount >= 3){
            map.removeActor(this);
            map.addActor(skeleton,boneLocation);
        } else if (!this.isConscious()){
            dropItemsOnLocation(skeleton, new Location(map, x, y));
            map.removeActor(this);
        }
        return new DoNothingAction();
    }

    /**
     * Drops the items from an actor class instance that activated Pile of Bones passive
     * @param actor The actor with the items
     * @param location Where the items will be dropped on death
     */
    public void dropItemsOnLocation(Actor actor, Location location){
        ActionList dropActions = new ActionList();
        for (Item item : actor.getItemInventory())
            dropActions.add(item.getDropAction(actor));
        for (WeaponItem weapon : actor.getWeaponInventory())
            dropActions.add(weapon.getDropAction(actor));
        for (Action drop : dropActions)
            drop.execute(this, location.map());
    }

    /**
     * Sets the allowable actions that can be conducted on pile of bones
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return An action
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            WeaponItem weapon;
            try{
                weapon = otherActor.getWeaponInventory().get(0);
            } catch (Exception e){
                weapon = null;
            }
            actions.add(new AttackAction(this, direction, weapon));
        }
        return actions;
    }

}
