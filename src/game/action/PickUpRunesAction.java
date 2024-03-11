package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.positions.GameMap;
import game.currency.Runes;
import game.currency.RunesManager;

/**
 * Action for the player to pick up runes
 *
 * @author Jun Choi
 * @version 2/5/2023
 */
public class PickUpRunesAction extends PickUpAction {
    /**
     * Runes
     */
    private final Runes runes;

    /**
     * Constructor for PickUpRunesAction
     * @param runes player runes
     */
    public PickUpRunesAction(Runes runes) {
        super(runes);
        this.runes = runes;
    }

    /**
     * When executed, remove the item from the location in the game map where the actor is currently standing on
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a description of the action suitable for feedback in the UI
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        map.locationOf(actor).removeItem(runes);
        RunesManager.getRunesManagerInstance().addRunes(runes.getValue());
        return menuDescription(actor);
    }

    /**
     * Describe the action in a format suitable for displaying in the menu.
     *
     * @see Action#menuDescription(Actor)
     * @param actor The actor performing the action.
     * @return a string, e.g. "Player picks up the rock"
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " picks up runes with value " + runes.getValue();
    }
}
