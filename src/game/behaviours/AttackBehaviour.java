package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.NumberRange;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Status;
import game.action.attackactions.AttackAction;
import game.action.WeaponSkillAction;
import game.enemy.EnemyCapabilities;

import java.util.Random;

import static java.lang.Math.abs;

/**
 * Attack Behaviour for Enemies
 *
 * Created by
 * @author Jun Choi
 * @version Updated as of 2/05/23
 */
public class AttackBehaviour implements Behaviour{


    /**
     * Random number generator
     */
    private Random rand = new Random();

    /**
     * Attack Behaviour Constructor
     */
    public AttackBehaviour(){
    }

    /**
     * Attack Behaviour Factory
     * Checks if the actor can attack another actor
     * Actor will attack if target is within one block and is a different class to itself
     *
     * @param actor the Actor acting
     * @param map   the GameMap containing the Actor
     * @return an Action that actor can perform, or null if actor can't do this.
     * @author Jun Choi
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        if(!map.contains(actor))
            return null;

        Location enemyLocation = map.locationOf(actor);

        int radius = 1;
        NumberRange xs, ys;
        xs = new NumberRange(enemyLocation.x() - 1, (radius*2 + 1));
        ys = new NumberRange(enemyLocation.y() - 1, (radius*2 + 1));

        Actor target = null;
        for (int i = xs.min(); i < xs.max() + 1; i++) {
            for (int j = ys.min(); j < ys.max() + 1; j++) {
                Actor actorAtLocation = map.getActorAt(new Location(map, i, j));
                if (actorAtLocation != null) {
                    target = map.getActorAt(new Location(map, i, j));
                    if (actorAtLocation.hasCapability(Status.HOSTILE_TO_ENEMY)){
                        break;
                    }
                }
            }
        }
        if (target == null || actor.getClass().equals(target.getClass())){
            return null;
        }

        int useSkill = rand.nextInt(100);
        WeaponItem weapon;
        try {
            weapon = actor.getWeaponInventory().get(0);
        }
        catch (Exception e){
            weapon = null;
        }

        if ((useSkill < 50 || actor.hasCapability(EnemyCapabilities.CAN_USE_SKILL)) && weapon != null){
            return new WeaponSkillAction(target,"attackDirection", weapon);
        } else {
            return new AttackAction(target, "attackDirection", weapon);
        }

    }
}
