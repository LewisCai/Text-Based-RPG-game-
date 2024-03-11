package game.weapons.weaponskills;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.action.attackactions.AttackAction;

import java.util.ArrayList;
import java.util.Random;

public class Quickstep extends Action {
    private final Actor target;

    private final WeaponItem weaponItem;

    private final String direction;

    public Quickstep(Actor target, String direction, WeaponItem weaponItem) {
        this.target = target;
        this.direction = direction;
        this.weaponItem = weaponItem;
    }

    /**
     * Perform the Spinning Attack.
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return a description of what happened that can be displayed to the user.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String result = "";
        result += new AttackAction(target, direction, weaponItem).execute(actor, map);

        Location actorLocation = map.locationOf(actor);
        Location targetLocation = map.locationOf(target);

        ArrayList<Location> possibleLocations = new ArrayList<>();
        for (Exit exit : actorLocation.getExits()){
            Location destination = exit.getDestination();
            if (destination.canActorEnter(actor)) {
                possibleLocations.add(destination);
            }

        }

        Random rand = new Random();
        int index = rand.nextInt(possibleLocations.size()-1);
        Location newDestination = possibleLocations.get(index);

        result += new MoveActorAction(newDestination, "to a random location").execute(actor, map);

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
        return actor + " uses Quickstep";
    }
}