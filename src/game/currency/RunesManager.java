package game.currency;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.enemy.Enemy;

import static game.utils.RandomNumberGenerator.getRandomInt;

/**
 * Class of runes manager
 *
 * Created by:
 * @author Linjun Cai
 * Modified by:
 * @author Jun Choi
 * @version 3/5/2023
 */
public class RunesManager{
    /**
     * Rest manager instance
     */
    private static RunesManager runesManagerInstance = null;
    /**
     * Runes class instance
     */
    private static Runes playerRunes;
    /**
     * Player
     */
    private Actor player;

    /**
     * Constructor for Runes manager
     */
    private RunesManager() {
    }

    /**
     * Factory method for runes manager
     * @return Instance of runes manager
     */
    public static RunesManager getRunesManagerInstance() {
        if (runesManagerInstance == null) {
            runesManagerInstance = new RunesManager();
            playerRunes = new Runes(0);
        }
        return runesManagerInstance;
    }

    /**
     * Return Runes instance
     * @return Runes instance
     */
    public Runes getRunesAsItem(){
        return playerRunes;
    }

    /**
     * Setter for player
     * @param player Player
     */
    public void setPlayer(Actor player){
        this.player = player;
    }

    /**
     * Getter for current runes
     * @return current number of runes
     */
    public int getCurrentPlayerRunes() {
        return playerRunes.getValue();
    }

    /**
     * Setter for current player runes
     * @param currentPlayerRunes New number of runes total
     */
    public void setCurrentPlayerRunes(int currentPlayerRunes) {
        playerRunes.setValue(currentPlayerRunes);
    }

    /**
     * Adding runes to the runes total
     * @param runes amount of runes to add to the total
     */
    public void addRunes(int runes){
        playerRunes.setValue(playerRunes.getValue() + runes);
    }

    /**
     * Remove runes from runes total.
     * @param runes Runes to deduct.
     */
    public void removeRunes(int runes) {
        playerRunes.setValue(playerRunes.getValue() - runes);
    }

    /**
     * Add the runes get from defeating an enemy to player's rune total
     * @param defeatedEnemy Enemy defeated by player
     */
    public void dropRunesFromEnemy(Enemy defeatedEnemy) {
        int runesGained = getRandomInt(defeatedEnemy.getRuneLowerBound(), defeatedEnemy.getRuneUpperBound());
        addRunes(runesGained);
    }

    /**
     * Drops rune at a certain location
     * @param location Location on map
     */
    public void dropRunesAtLocation(Location location){
        int currentValue = playerRunes.getValue();
        Runes droppedRunes = new Runes(currentValue);
        playerRunes.setValue(0);
        location.addItem(droppedRunes);
    }

}
