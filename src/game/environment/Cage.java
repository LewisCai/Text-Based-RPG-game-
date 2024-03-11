package game.environment;

import edu.monash.fit2099.engine.positions.Location;
import game.enemy.stormveil.Dog;
import game.enemy.Enemy;
import game.utils.RandomNumberGenerator;


/**
 * It is represented as <. It spawns Dogs with a 37% chance at each turn.
 * version 20/05/2023
 */
public class Cage extends Environments {

    /**
     * Cage public constructor
     *
     * @see Environments
     */
    public Cage() {
        super('<');
    }


    /**
     * Check whether the location contains an actor or not and whether the actor is in this case enemy is following
     * the player or not. If following perform deSpawn method. If the location does not contain an actor and the actor.
     * with 37% chance at the location of the map.
     *
     * @param location The location of the Ground
     */
    public void tick(Location location) {
        if (!location.containsAnActor()) {
            Enemy dog = new Dog();
            if (!dog.isFollowing()) {
                if (RandomNumberGenerator.getRandomInt(1, 100) <= 37) {
                    location.addActor(dog);
                }
            } else {
                deSpawn(location);
            }
        }
    }
}
