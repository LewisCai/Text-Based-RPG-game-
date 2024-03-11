package game.enemy.east;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.Behaviour;
import game.enemy.enemytype.Canine;

/**
 * BEHOLD, DOG!
 *
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *  Jun Choi
 *
 */
public class LoneWolf extends Canine {

    /**
     * Lone Wolf Private constructor
     * @see Canine
     */
    public LoneWolf() {
        super("Lone Wolf", 'h', 102);
        this.setRuneBoundaries(55, 1470);
    }

}
