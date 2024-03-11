package game.enemy.east;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.enemy.enemytype.Crustacean;
import game.enemy.EnemyCapabilities;
import game.unarmed.Slamable.GiantClaw;

/**
 * Giant Crab Class
 *
 * Created by:
 * @author Jun Choi
 * @version Updated as of 2/05/23
 */
public class GiantCrab extends Crustacean {

    /**
     * Giant Crab public constructor
     *
     * No Parameters, values will be inserted straight into super class constructor
     */
    public GiantCrab() {
        super("Giant Crab", 'h', 407);
        this.setRuneBoundaries(318,4961);
        this.addWeaponToInventory(new GiantClaw());
        this.addCapability(EnemyCapabilities.CAN_USE_SKILL);
    }

    /**
     * Returns Intrinsic Weapon for Giant Crabs
     * @return IntrinsicWeapon of Giant Crab
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(106, "Slams", 76 );
    }
}
