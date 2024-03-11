package game.enemy.west;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.enemy.enemytype.Canine;
import game.enemy.enemytype.Skeleton;
import game.weapons.Scimitar;

/**
 * SkeletalBandit Class
 *
 * Created by:
 * @author Jun Choi
 * @version Updated as of 2/05/23
 */
public class SkeletalBandit extends Skeleton {
    /**
     * Skeletal Bandit public constructor
     * @see Canine
     */
    public SkeletalBandit() {
        super("Skeletal Bandit", 'b', 693, new Scimitar());
        this.setRuneBoundaries(35,892);
    }


    /**
     * Returns the Intrinsic Weapon of SkeletalBandit
     * @return IntrinsicWeapon of SkeletalBandit class
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(314, "Slams", 90);
    }
}
