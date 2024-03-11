package game.unarmed.Slamable;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.NumberRange;
import game.action.DeathAction;
import game.action.attackactions.AreaAttackAction;


import java.util.Random;

/**
 * Slam unique ability action class
 *
 * Created by:
 * @author Jun Choi
 * @version Updated as of 18/05/23
 */
public class SlamAction extends Action {
    /**
     * The Actor that is to be attacked
     */
    private Actor target;

    /**
     * The amount of damage that slam does in each successful hit.
     */
    private int damage;

    /**
     * The chance of successfully landing slam.
     */
    private int hitrate;

    /**
     * Public Constructor for slam action
     *
     * @param target the receiving actor
     * @param damage the amount of damage this skill deals
     * @param hitrate the success rate of this skill
     */
    public SlamAction(Actor target, int damage, int hitrate){
        this.target = target;
        this.damage = damage;
        this.hitrate = hitrate;
    }

    /**
     * Perform Slam Attack
     * This method takes the location of the target and checks each square within a given radius for actors.
     * For each actor that exists in each square, the method has an independent hitrate for each actor meaning
     * even if it hits one actor, another actor in the same area might not also get hit.
     * Each actor that has died will perform a death action and drop their items.
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return a description of what happened that can be displayed to the user.
     * @see AreaAttackAction
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String result = System.lineSeparator() + actor + " slammed " + target + " for " + damage;
        Action AOEAttack = new AreaAttackAction(target, damage, hitrate);
        result += System.lineSeparator() + AOEAttack.execute(actor, map);
        if (!target.isConscious()) {
            result += System.lineSeparator() + new DeathAction(target).execute(target, map);
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
        return actor + " slammed against " + target;
    }
}
