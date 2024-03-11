package game.weapons.statuseffect;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.action.DeathAction;

/**
 * A Status Effect Action for Poison Damage
 * @author Jun Choi
 * @version Updated as of 18/05/2023
 */
public class PoisonAction extends Action implements StatusEffect {

    /**
     * When executed, Poison damage is applied to the enemy.
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return a description of what happened that can be displayed to the user.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String result = actor + " is damaged by poison. Their health will drain by 40hp per turn.";
        int damagePerTurn = 40;
        actor.hurt(damagePerTurn);
        if (!actor.isConscious()) {
            result += new DeathAction(actor).execute(actor, map);
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
        return actor + " is Poisoned";
    }

    /**
     * Gets the total number of turns that the status effect will be in effect for
     * @return an integer representing the number of turns
     */
    @Override
    public int getPlayCount() {
        return 4;
    }
}
