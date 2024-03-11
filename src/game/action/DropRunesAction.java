package game.action;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.currency.RunesManager;

/**
 *  Action made for specifically dropping Runes
 *  Created by
 * @author Jun Choi
 * @Version 3/05/23
 */
public class DropRunesAction extends DropAction {
    private Item item;

    /**
     * Constructor.
     *
     * @param item the item to drop
     */
    public DropRunesAction(Item item) {
        super(item);
        this.item = item;
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
        RunesManager manager = RunesManager.getRunesManagerInstance();
        Location dropLocation = map.locationOf(actor);
        manager.dropRunesAtLocation(dropLocation);
        manager.setCurrentPlayerRunes(0);
        return menuDescription(actor);
    }

    /**
     * Menu Description
     * @param actor The actor performing the action.
     * @return A string to be presented on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Drop All Runes";
    }
}
