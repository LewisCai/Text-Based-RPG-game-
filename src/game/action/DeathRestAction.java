package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.gamereset.ResetManager;

/**
 * Action for player death
 * created by
 * @author Lunjun Cai
 * @version 2/5/2023
 *
 */
public class DeathRestAction extends Action {
    /**
     * Execute player death action by run RestManager to rest the game based on player death
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return Message indicates player died.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        ResetManager.getInstance().runRest(actor, map);
        return "YOU DIED";
    }

    /**
     * Returns menu description of player death
     * @param actor The actor performing the action.
     * @return Message indicates player died.
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " Died";
    }
}
