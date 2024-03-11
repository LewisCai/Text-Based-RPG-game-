package game.consumable;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.action.ConsumeAction;
import game.gamereset.ResetManager;
import game.gamereset.Resettable;

/**
 * FlaskOfCrimsonTears Item Class
 * Created by
 * @author Jun Choi
 * @version 2/05/23
 */
public class FlaskOfCrimsonTears extends Item implements Resettable, Consumables{
    /**
     * Instance of flaskInstance
     */
    private static FlaskOfCrimsonTears flaskInstance = null;
    /**
     * max number of flasks
     */
    private static int maxFlasks = 2;
    /**
     * Available number of flasks
     */
    private int availableAmount;

    /***
     * Private FlaskOfCrimsonTears Constructor
     */
    private FlaskOfCrimsonTears() {
        super("Flask of Crimson Tears", '-', false);
        this.availableAmount = maxFlasks;
    }

    /**
     * Public factory method for creating the flask of Crimson Tears.
     * @return An instance of the flask of Crimson Tears, with values and actions set.
     */
    public static FlaskOfCrimsonTears getFlaskInstance(){
        if (flaskInstance == null) {
            flaskInstance = new FlaskOfCrimsonTears();
            flaskInstance.addAction(new ConsumeAction(flaskInstance));
            flaskInstance.registerInManager();
        }
        return flaskInstance;
    }

    /**
     * Getter method for getting the maximum capacity of flasks
     * @return An integer representing the max amount
     */
    public int getMaxFlasks(){
        return maxFlasks;
    }

    /**
     * Getter method for getting the current amount of flasks usable
     * @return An integer representing the current amount of flasks
     */
    public int getAvailableAmount(){
        return this.availableAmount;
    }

    @Override
    public String getSuccessMessage() {
        return "Healed 250 HP with Flask of Crimson Tears";
    }

    @Override
    public String getFailMessage() {
        return "Cannot heal, player has no more Crimson Tears";
    }

    @Override
    public String getMenuMessage() {
        return "Tarnished uses Flash of Crimson Tears (" + this.getAvailableAmount() + "/" + this.getMaxFlasks() + ")";
    }

    /**
     * Decrementer for when a flask of Crimson Tears is consumed.
     */
    public void decrementAmount(){
        if (availableAmount > 0){
            availableAmount -= 1;
        }
    }

    /**
     * Resets the total amount to the max amount
     */
    public void setToMax(){
        this.availableAmount = maxFlasks;
    }

    /**
     * rests the number of flasks to max
     * @param actor Player
     * @param map Map that player is in
     */
    @Override
    public void reset(Actor actor, GameMap map) {
        availableAmount = maxFlasks;
    }

    /**
     * Register flask in rest manager
     */
    @Override
    public void registerInManager() {
        ResetManager.getInstance().registerResettable(flaskInstance);
    }

    @Override
    public void consume(Actor actor) {
        actor.heal(250);
        this.decrementAmount();
    }
}
