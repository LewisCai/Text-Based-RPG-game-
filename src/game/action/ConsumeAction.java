package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.consumable.Consumables;

/**
 * FlaskOfCrimsonTears Action Class
 * Created by
 * @author Jun Choi
 * @version 2/05/23
 */
public class ConsumeAction extends Action {

    /**
     * An instance of the FlaskOfCrimsonTears Item
     */
    private final Consumables consumable;

    /**
     * Public constructor
     * @param consumable is the soncumable item
     */
    public ConsumeAction(Consumables consumable){
        this.consumable = consumable;
    }


    /**
     * Heals the player through consuming a flask of crimson tears.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return A string to determine if the player successfully used a flask
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (consumable.getAvailableAmount() > 0) {
            consumable.consume(actor);
            return consumable.getSuccessMessage();
        } else {
            return consumable.getFailMessage();
        }
    }

    /**
     * Menu Description of this consumable item
     * @param actor The actor performing the action.
     * @return A string to be presented in the menu display
     */
    @Override
    public String menuDescription(Actor actor) {
        return consumable.getMenuMessage();
    }
}
