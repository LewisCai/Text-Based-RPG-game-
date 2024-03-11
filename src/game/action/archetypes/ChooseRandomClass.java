package game.action.archetypes;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;

import java.util.ArrayList;
import java.util.Random;
/**
 * Action for choosing at random
 * Created by
 * @author Jun Choi
 * @version Updated as of 20/05/23
 */
public class ChooseRandomClass {
    /**
     * To choose random class
     * @return the selection of action
     */
    public static Action chooseClass(){
        ActionList actionList = new ActionList();
        actionList.add(new ChooseSamuraiAction());
        actionList.add(new ChooseBanditAction());
        actionList.add(new ChooseWretchAction());
        actionList.add(new ChooseAstrologerAction());

        Random rand = new Random();
        int selection = rand.nextInt(actionList.size());
        return actionList.get(selection);
    }
}
