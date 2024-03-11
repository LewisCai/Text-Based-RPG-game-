package game.environment;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.enemy.Enemy;
import game.enemy.EnemyCapabilities;

import java.util.Random;


/**
 * This abstract environments class represents the environment in the game, which provides a common constructor for all
 * the environments in the game. Which are Graveyard, PuddleOfWater, Tree, and Wind as subclasses of this class.
 * Then accepting the symbol of the environment as the parameter to represent the environment in the map.
 *
 * version 20/05/2021
 */
public abstract class Environments extends Ground{

    /**
     * Constructor.
     * This environment is represented by a symbol in the map. It can be a puddle of water, a gust of wind, or a tree.
     * depending on the symbol.
     * @param symbol the symbol of this type of ground
     */
    public Environments(char symbol){
        super(symbol);
    }

    /**
     * A method that is used to tick the environment.
     * @param location The location of the Ground
     */
    public void tick(Location location) {
    }

    /**
     * A method that is used to deSpawn Enemy at specific location with 10% chance of deSpawning.
     * if it contains an actor, it will check if the actor is an instance of Enemy.
     * if it is, it will remove the actor from the location with 10% chance of deSpawning.
     * Otherwise, it will do nothing.
     *
     * @param location The location of the Ground
     */

    public void deSpawn(Location location){
        Random rand = new Random();
        int deSpawnChance = rand.nextInt(100);
        if (location.containsAnActor()){
            Actor enemy = location.getActor();
            if (deSpawnChance <= 10){
                Actor currentActor = location.getActor();
                if (currentActor.hasCapability(EnemyCapabilities.ENEMY) && currentActor.hasCapability(EnemyCapabilities.IS_FOLLOWING)){
                    location.map().removeActor(enemy);
                }
            }

        }
    }

    /**
     * A method that is used to spawn Enemy by east and west side under each subclasses of Environments.
     * it will take the size of the input map and divide it by 2 to get the middle of the map.
     * then determine the spawn area by comparing the x value of the location and the middle of the map.
     * if the x value of the location is greater than the middle of the map, it will return Direction.EAST.
     * if the x value of the location is less than the middle of the map, it will return Direction.WEST.
     * @param location The location of the Ground
     * @return String that states the direction of the spawn area. "EAST" / "WEST"
     */

    public String determineSpawnArea(Location location) {
        int middleX = (int)Math.floor(location.map().getXRange().max() / 2);

        if (location.x() >= middleX) {
            return "EAST"; // Direction.EAST;
        } else {
            return "WEST"; // Direction.WEST;
        }
    }

}
