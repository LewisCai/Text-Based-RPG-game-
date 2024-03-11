package game.environment;

import edu.monash.fit2099.engine.positions.Location;
import game.enemy.Enemy;
import game.enemy.stormveil.GodrickSoldier;
import game.utils.RandomNumberGenerator;

/**
 * It is represented as B. It spawns GodrickSoldiers with a 45% chance at each turn.
 * version 20/05/2023
 */
public class Barrack extends Environments {

    /**
     * Barrack public constructor
     *
     * @see Environments
     */
    public Barrack() {
        super('B');
    }


    /**
     * Check whether the location contains an actor or not and whether the actor is an instance of Player or not
     * If the location does not contain an actor and the actor is an instance of Player, then spawn a GodrickSoldier
     * with 45% chance at the location of the map.
     *
     * @param location The location of the Ground
     */
    public void tick(Location location) {
        if (!location.containsAnActor()) {
            Enemy godrickSoldier = new GodrickSoldier();
            if (!godrickSoldier.isFollowing()) {
                if ((RandomNumberGenerator.getRandomInt(1, 100) <= 45)) {
                    location.addActor(godrickSoldier);
                }
            } else {
                deSpawn(location);
            }
        }
    }
}

