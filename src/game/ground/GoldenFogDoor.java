package game.ground;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.*;
import game.action.DoorTravelAction;
import game.action.RestAction;

import java.util.List;


/**
 * A class that represents the door that is used to travel between maps
 * @see Ground
 *
 * version 20/05/2023
 */
public class GoldenFogDoor extends Ground {
    private String destinationName;
    private Location currentLocation;
    private World world;

    /**
     * GoldenFogDoor public constructor
     * @see Ground
     */
    public GoldenFogDoor(Location currentLocation, Location destinationLocation, String destinationName, World world) {
        super('D');
        Exit exit = new Exit(destinationName, destinationLocation, "door");
        currentLocation.addExit(exit);
        this.destinationName = destinationName;
        this.world = world;
        this.currentLocation = currentLocation;
    }

    /**
     * This method returns the list of allowable actions for a given actor in a given location and direction.
     * The actions are determined by the current state of the game, the actor's location, and the direction.
     * In this implementation, the actor can perform a DoorTravelAction to move to a new location.
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction){
        ActionList actions = new ActionList();
        actions.add(new DoorTravelAction(destinationName, currentLocation, world));//I used location from parameter but it has bug, so i created a new variable current location
        return actions;
    }
}

