package game.friendly;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Status;
import game.action.archetypes.ChooseRandomClass;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.FriendlyAttackBehaviour;
import game.behaviours.WanderBehaviour;
import game.gamereset.ResetManager;
import game.gamereset.ResetStatus;
import game.gamereset.Resettable;

import java.util.HashMap;
import java.util.Map;

/**
 * Ally Actor
 * Friendly to the player
 *
 * @author Jun Choi
 * @version 20/05/2023
 */
public class Ally extends Friendly  {

    /**
     * Ally Constructor
     *
     */
    public Ally() {
        super("Ally", 'A', 100);
        ChooseRandomClass.chooseClass().execute(this, null);
    }
}
