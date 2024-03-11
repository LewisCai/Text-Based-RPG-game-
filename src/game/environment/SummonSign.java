package game.environment;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.action.RestAction;
import game.action.SummonAction;

/**
 * Summon Sign environment for summoning an ally or invader
 * @author Jun Choi
 * @version 20/05/2023
 */
public class SummonSign extends Environments{

    /**
     * Constructor.
     * This environment is represented by a symbol in the map. It can be a puddle of water, a gust of wind, or a tree.
     * depending on the symbol.
     *
     */
    public SummonSign() {
        super('=');
    }

    /**
     * Returns the summoning action
     * @param location The location of the Ground
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        return new ActionList(new SummonAction(location));
    }
}
