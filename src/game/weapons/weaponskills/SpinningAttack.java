package game.weapons.weaponskills;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.action.attackactions.AreaAttackAction;

public class SpinningAttack extends Action {
    /**
     * The amount of damage that slam does in each successful hit.
     */
    private int damage;

    /**
     * The chance of successfully landing spinning attack.
     */
    private int hitrate;


    public SpinningAttack(int damage, int hitrate) {
        this.damage = damage;
        this.hitrate = hitrate;
    }

    /**
     * Perform the Spinning Attack.
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a description of what happened that can be displayed to the user.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        Action areaAttack = new AreaAttackAction(actor, damage, hitrate);
        String result = System.lineSeparator() + actor + " used Spinning Attack";
        result += areaAttack.execute(actor, map);
        return result;
    }

    /**
     * Returns a descriptive string
     * @param actor The actor performing the action.
     * @return the text we put on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " uses Spinning Attack";
    }
}
