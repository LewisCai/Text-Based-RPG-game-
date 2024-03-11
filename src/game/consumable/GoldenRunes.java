package game.consumable;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.currency.RunesManager;
import game.utils.RandomNumberGenerator;
/**
 * Golden runes Item class
 * Created by
 * @author Linjun Cai
 * @version 20/05/23
 */
public class GoldenRunes extends Item implements Consumables {
    /**
     * available amount of golden runes
     */
    private int availableAmount = 0;
    /***
     * Constructor.
     */
    public GoldenRunes() {
        super("Golden Runes", '*', true);
    }

    /**
     * Consumes the golden runes
     * @param actor player
     */
    @Override
    public void consume(Actor actor) {
        RunesManager.getRunesManagerInstance().addRunes(RandomNumberGenerator.getRandomInt(200, 10000));
    }

    /**
     * Set the amount of consumable items
     * @param num new available amount of golden runes
     */
    public void setAvailableAmount(int num){
        availableAmount = num;
    }

    /**
     * Getter for available amount
     * @return
     */
    @Override
    public int getAvailableAmount() {
        return availableAmount;
    }

    /**
     * Message for consuming golden runes
     * @return string of success message
     */
    @Override
    public String getSuccessMessage() {
        return "Consumed golden runes";
    }
    /**
     * Message for consuming golden runes
     * @return string of fail message
     */
    @Override
    public String getFailMessage() {
        return "No more golden runes";
    }
    /**
     * Message for option to consuming golden runes on the menu
     * @return string of option on the menu
     */
    @Override
    public String getMenuMessage() {
        return "Tarnished consumes golden runes / " + availableAmount +" remaining.";
    }
}
