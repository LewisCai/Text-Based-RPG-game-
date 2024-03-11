package game.enemy.west;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.enemy.enemytype.Canine;
import game.enemy.EnemyCapabilities;
import game.unarmed.Slamable.GiantHead;

/**
 * GiantDog Class
 *
 * Created by:
 * @author Jun Choi
 * @version Updated as of 2/05/23
 */
public class GiantDog extends Canine {

    /**
     * Giant Dog public constructor
     * @see Canine
     */
    public GiantDog() {
        super("Giant Dog", 'G', 693);
        this.setRuneBoundaries(313, 1808);
        this.addWeaponToInventory(new GiantHead());
        this.addCapability(EnemyCapabilities.CAN_USE_SKILL);
    }


    /**
     * Returns the Intrinsic Weapon of Giant Dog
     * @return IntrinsicWeapon of Giant Dog class
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(314, "Slams", 90);
    }
}
