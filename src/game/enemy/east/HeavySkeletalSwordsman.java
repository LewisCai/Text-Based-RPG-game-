package game.enemy.east;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.weapons.GreatKnife;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.WanderBehaviour;
import game.enemy.enemytype.Skeleton;
import game.weapons.Grossmesser;


/**
 * HeavySkeletalSwordsman Class
 *
 * Created by:
 * @author Jun Choi
 * @version Updated as of 2/05/23
 */
public class HeavySkeletalSwordsman extends Skeleton {

    /**
     * Heavy Skeletal Swordsman public constructor
     *
     * No Parameters, values will be inserted straight into super class constructor
     */
    public HeavySkeletalSwordsman() {
        super("Heavy Skeletal Swordsman", 'q', 153, new Grossmesser());
        this.setRuneBoundaries(35, 892);
    }

}
