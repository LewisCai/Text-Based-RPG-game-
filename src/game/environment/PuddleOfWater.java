package game.environment;

import edu.monash.fit2099.engine.positions.Location;
import game.enemy.west.GiantCrayfish;
import game.utils.RandomNumberGenerator;
import game.enemy.Enemy;
import game.enemy.east.GiantCrab;

import java.util.Objects;

/**
 * A class that represents the PuddleOfWater environment.
 * It is a subclass of Environments, and initialized with a displayChar of '~' to represent the PuddleOfWater area.
 * Including the tick method and implements Spawn interface to perform spawning action.
 * Which is used to spawn Enemy GiantCrab with 2% chance.
 */
public class PuddleOfWater extends Environments {


    /**
     * initialize the displayChar of the Ground to '~'.
     */
    public PuddleOfWater() {
        super('~');
    }

    /**
     * A method that uses tick then takes Location as parameter to indicate the location of the Ground.
     * Then it will check if the location contains an actor, if it does, it will spawn an Enemy GiantCrayfish
     * and GiantCrab with 2% and 1% chance at the location of the map at the east / west of the map.
     * Using methods from Environment parent class to determine the spawn area. Then perform spawning action.
     * if location has actor standing on it, it will go through he deSpawn method to remove the actor if deSpawn chance
     * meet.
     * @param location The location of the Ground
     */

    @Override
    public void tick(Location location) {
        if (!location.containsAnActor()) {
            String area = determineSpawnArea(location);
            if (Objects.equals(area, "EAST")) {
                if (RandomNumberGenerator.getRandomInt(1, 100) <= 2) {
                    Enemy eastEnemy = new GiantCrayfish();
                    location.addActor(eastEnemy);
                }
            } else if (Objects.equals(area, "WEST")) {
                if (RandomNumberGenerator.getRandomInt(1, 100) <= 1) {
                    Enemy westEnemy = new GiantCrab();
                    location.addActor(westEnemy);
                }
            }
        } else {
            deSpawn(location);
        }
    }
}

