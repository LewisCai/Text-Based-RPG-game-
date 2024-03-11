package game.environment;

import edu.monash.fit2099.engine.positions.Location;
import game.enemy.Enemy;
import game.enemy.west.GiantDog;
import game.utils.RandomNumberGenerator;
import game.enemy.east.LoneWolf;

import java.util.Objects;

/**
 * A class that represents the graveyard environment.
 * It is a subclass of Environments, and initialized with a displayChar of '&' to represent the graveyard area.
 * Including the tick method and implements Spawn interface to perform spawning action.
 * Which is used to spawn Enemy HeavySkeletalSwordsman with 27% chance.
 */
public class GustOfWind extends Environments {

    /**
     * initialize the displayChar of the Ground to '&'.
     */
    public GustOfWind() {
        super('&');
    }

    /**
     * A method that uses tick then takes Location as parameter to indicate the location of the Ground.
     * Then it will check if the location contains an actor, if it does, it will spawn an Enemy GiantDog
     * and LoneWolf with 4% and 33% chance at the location of the map at the east / west of the map.
     * Using methods from Environment parent class to determine the spawn area. Then perform spawning action.
     * if location has actor standing on it, it will go through he deSpawn method to remove the actor if deSpawn chance
     * meet.
     *
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        if (!location.containsAnActor()) {
            String area = determineSpawnArea(location);

            if (Objects.equals(area, "EAST")) {
                if (RandomNumberGenerator.getRandomInt(1, 100) <= 4) {
                    Enemy eastEnemy = new GiantDog();
                    location.addActor(eastEnemy);
                }
            } else if (Objects.equals(area, "WEST")) {
                if (RandomNumberGenerator.getRandomInt(1, 100) <= 33) {
                    Enemy westEnemy = new LoneWolf();
                    location.addActor(westEnemy);
                }
            }
        } else {
            deSpawn(location);
        }
    }
}