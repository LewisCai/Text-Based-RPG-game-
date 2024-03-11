package game.utils;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.positions.GameMap;
import game.action.archetypes.ChooseAstrologerAction;
import game.action.archetypes.ChooseBanditAction;
import game.action.archetypes.ChooseSamuraiAction;
import game.action.archetypes.ChooseWretchAction;
/**
 * ArchetypesMenu class
 * Outputs menu description for each action that choose combat archetypes, and choose archetypes based on user
 * input.
 * @author Linjun Cai
 * @version 3/5/2023
 */
public class ArchetypesMenu {
    /**
     * Menu class
     */
    private Menu menu = new Menu();
    /**
     * Display class
     */
    private Display display = new Display();
    /**
     * Action list class
     */
    private ActionList actionList = new ActionList();

    /**
     *  Constructor for ArchetypesMenu
     * @param actor Player
     * @param map The current game map
     */
    public ArchetypesMenu(Actor actor, GameMap map){
        display.println("Select your role: ");
        actionList.add(new ChooseSamuraiAction());
        actionList.add(new ChooseBanditAction());
        actionList.add(new ChooseWretchAction());
        actionList.add(new ChooseAstrologerAction());
        menu.showMenu(actor, actionList, display).execute(actor, map);
    }
}
