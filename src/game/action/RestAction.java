package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.gamereset.ResetManager;
import game.gamereset.Resettable;

/**
 * Class of rest action
 *
 * @author Linjun Cai
 * @version 2/5/2023
 */

public class RestAction extends Action {
    /**
     * Name of the Lost site of grace
     */
    private String name;


    private Location siteLocation;

    /**
     * Constructor
     * @param name nam of the lost site of grace
     */
    public RestAction(String name, Location location){
        this.name = name;
        this.siteLocation = location;
    }

    /**
     * Executes the rest action by calling rest manager
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return string
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        ResetManager manager = ResetManager.getInstance();
        manager.setSiteOfLostGraceLoc(siteLocation, name);
        manager.removeResettable((Resettable) actor);
        manager.runRest(actor, map);
        manager.registerResettable((Resettable) actor);
        actor.heal(999999);
        return actor + " rest at Lost Grace";
    }

    /**
     * Return menu description
     * @param actor The actor performing the action.
     * @return Message to display on menu
     */

    @Override
    public String menuDescription(Actor actor) {
        return actor + " rest at " + name + " Lost Site of Grace. ";
    }
}
