package game.weapons.statuseffect;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.action.DeathAction;
import game.action.attackactions.AreaAttackAction;

/**
 * A Burn Status Effect Action
 *
 * @author Jun Choi
 * @version Updated as of 18/05/2023
 */
public class BurnAction extends Action implements StatusEffect{
    /**
     * Perform Burn Action, where an enemy will burn for multiple turns.
     * Any enemies that surround the target are scorched meaning they will not be burned but heavily damaged.
     * Note: Fire does not spread
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return a description of what happened that can be displayed to the user.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String result = actor + " is burned by fire. All those around got Scorched.";
        int damage = 100;
        actor.hurt(100);
        Action AOEBurn = new AreaAttackAction(actor, damage, 100);
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
        return actor + " is burned";
    }

    @Override
    public int getPlayCount() {
        return 4;
    }
}
