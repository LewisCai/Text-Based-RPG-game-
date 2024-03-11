package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.World;

import java.util.List;

public class DoorTravelAction extends Action {
    private final Location currentLocation;
    private final String name;
    private final World world;

    public DoorTravelAction(String name, Location currentLocation, World world){
        this.world = world;
        this.currentLocation = currentLocation;
        this.name = name;
    }
    @Override
    public String execute(Actor actor, GameMap map) {
        map.removeActor(actor);
        List<Exit> exits = currentLocation.getExits();
        for (int i = 0 ; i < exits.size() ; i++){
            System.out.println(this.name + exits.get(i).getName());
            if(this.name.equals(exits.get(i).getName())){
                world.addPlayer(actor, exits.get(i).getDestination());
            }
        }
        return null;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " goes thought the door to " + name;
    }
}
