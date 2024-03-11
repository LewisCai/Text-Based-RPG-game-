package game.consumable;

import edu.monash.fit2099.engine.actors.Actor;
/**
 * Consumable interface Class
 * Created by
 * @author Linjun Cai
 * @version 18/05/23
 */
public interface Consumables {
    /**
     * Consume action
     * @param actor player
     */
    public void consume(Actor actor);

     /**
     * Getter for the available amount of the items
     * @return integer of the amount
     */
     public int getAvailableAmount();

    /**
     * Getter for item consume success message
     * @return String of message of success
     */
    public String getSuccessMessage();

    /**
     * Getter for item consume fail message
     * @return String of message of failure
     */
    public String getFailMessage();

    /**
     * Getter for message at the menu
     * @return String to put on th menu
     */
    public String getMenuMessage();
}
