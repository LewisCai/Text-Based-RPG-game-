package game.action.archetypes;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.currency.Runes;
import game.weapons.GreatKnife;

/**
 * Action class for player to choose archetype Bandit
 * @author Linjun Cai
 * @version 3/5/2023
 */
public class ChooseBanditAction extends Action {
    /**
     * Execute the action by add the associate weapon to player and set max HP
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return Null No message needed
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        actor.addItemToInventory(new Runes(0));
        actor.addWeaponToInventory(new GreatKnife());
        actor.resetMaxHp(414);
        return null;
    }

    /**
     * Display the option as assigned key
     * @return Assigned key
     */
    @Override
    public String hotkey(){
        return "b";
    }

    /**
     * Returns the menu description for combat archetype
     * @param actor The actor performing the action.
     * @return Name of archetype
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Bandit";
    }
}
