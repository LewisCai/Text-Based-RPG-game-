package game.action.attackactions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.action.DeathAction;

import java.util.Random;

/**
 * A general Attack Action that damages an area of individuals
 * @author Jun Choi
 * @version Updated as of 18/05/2023
 */
public class AreaAttackAction extends Action {

    /**
     * The Actor that is to be attacked
     */
    private final Actor target;

    /**
     * The amount of damage that slam does in each successful hit.
     */
    private final int damage;

    /**
     * The chance of successfully landing slam.
     */
    private final int hitrate;

    /**
     * Any action being applied to a target
     */
    private Action action;

    /**
     * Random number generator
     */
    private Random rand = new Random();

    /**
     * Constructor for Area Attack Actions with extra actions for each receiver of damage
     * @param target The main Target Actor
     * @param damage Damage taken
     * @param hitrate Chance to be hit
     * @param action Action to be executed on each receiving actor
     */
    public AreaAttackAction(Actor target, int damage, int hitrate, Action action){
        this.damage = damage;
        this.hitrate = hitrate;
        this.action = action;
        this.target = target;
    }

    /**
     * Constructor for Area Attack Actions where each receiver only takes damage
     * @param target The main Target Actor
     * @param damage Damage taken
     * @param hitrate Chance to be hit
     */
    public AreaAttackAction(Actor target, int damage, int hitrate){
        this.damage = damage;
        this.hitrate = hitrate;
        this.target = target;
    }

    /**
     * Perform the Action.
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return a description of what happened that can be displayed to the user.
     */
    @Override
    public String execute(Actor actor, GameMap map) {

        Location actionLocation = map.locationOf(target);
        String result = "";

        if (actor != target){
            if (rand.nextInt(100) < hitrate) {
                target.hurt(damage);
            } else {
                result += System.lineSeparator() + actor + " missed against " + target;
            }
        }

        for (Exit exit : actionLocation.getExits()) {
            Location destination = exit.getDestination();
            if (destination.containsAnActor()){
                Actor receiver = destination.getActor();
                if (receiver == actor){
                    continue;
                }
                if (rand.nextInt(100) < hitrate) {
                    receiver.hurt(damage);
                    result += System.lineSeparator() + actor + " hurt " + receiver + " for " + damage + " damage. (Area Damage)";
                    if (action != null){
                        result += System.lineSeparator() + action.execute(receiver, map);
                    }

                    if (!receiver.isConscious()){
                        result += System.lineSeparator() + new DeathAction(receiver).execute(receiver, map);
                    }
                } else {
                    result += System.lineSeparator() + actor + " missed against " + receiver ;
                }
            }
        }
        return result;
    }

    /**
     * Returns a descriptive string
     *
     * @param actor The actor performing the action.
     * @return the text we put on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " uses Area Damage";
    }

}
