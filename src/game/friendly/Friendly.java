package game.friendly;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Status;
import game.behaviours.Behaviour;
import game.behaviours.FriendlyAttackBehaviour;
import game.behaviours.WanderBehaviour;
import game.gamereset.ResetManager;
import game.gamereset.ResetStatus;
import game.gamereset.Resettable;

import java.util.HashMap;
import java.util.Map;

/**
 * Friendly Actor abstract class
 * @author Jun Choi
 * @version 20/05/2023
 */
public abstract class Friendly extends Actor implements Resettable {
    /**
     * Behaviour Hashmap to store behaviours by priority
     */
    protected Map<Integer, Behaviour> behaviours = new HashMap<>();

    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Friendly(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.addCapability(Status.HOSTILE_TO_ENEMY);
        this.addCapability(ResetStatus.ON_PLAYER_DEATH);
        setBehaviours();
        registerInManager();
    }

    public void setBehaviours(){
        behaviours.put(900, new WanderBehaviour());
        behaviours.put(5, new FriendlyAttackBehaviour());
    }

    /**
     * Select and return an action to perform on the current turn.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the Action to be performed
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if(action != null)
                return action;
        }
        return new DoNothingAction();
    }

    /**
     * Returns actions allowed on a Friendly
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        return new ActionList(new DoNothingAction());
    }

    /**
     * Reset the Friendly when player dies only
     * @param actor Player
     * @param map Map the player is on
     */
    @Override
    public void reset(Actor actor, GameMap map) {
        map.removeActor(this);
    }

    /**
     * Register the Friendly in the manager
     */
    @Override
    public void registerInManager() {
        ResetManager.getInstance().registerResettable(this);
    }
}
