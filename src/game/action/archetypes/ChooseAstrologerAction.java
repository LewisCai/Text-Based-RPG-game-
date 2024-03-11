package game.action.archetypes;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.currency.Runes;
import game.weapons.GreatKnife;

/**
 * Action for choosing Astrologer 
 * Created by
 * @author Jun Choi
 * @version Updated as of 20/05/23
 */
public class ChooseAstrologerAction extends Action {
    /**
     * Perform the Action.
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return a description of what happened that can be displayed to the user.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        actor.addItemToInventory(new Runes(0));
        actor.resetMaxHp(396);
        actor.addWeaponToInventory(new GreatKnife());
        return null;
    }

    @Override
    public String hotkey() {
        return "a";
    }

    /**
     * Returns a descriptive string
     *
     * @param actor The actor performing the action.
     * @return the text we put on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Astrologer";
    }


}
