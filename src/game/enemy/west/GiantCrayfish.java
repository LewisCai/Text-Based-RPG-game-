package game.enemy.west;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.currency.Runes;
import game.enemy.enemytype.Canine;
import game.enemy.enemytype.Crustacean;
import game.enemy.EnemyCapabilities;
import game.unarmed.Slamable.GiantPincer;

/**
 * GiantCrayfish Class
 *
 * Created by:
 * @author Jun Choi
 * @version Updated as of 2/05/23
 */
public class GiantCrayfish extends Crustacean {


    /**
     * Giant Crayfish public constructor
     * @see Canine
     */
    public GiantCrayfish() {
        super("Giant Crayfish", 'R', 4803);
        this.setRuneBoundaries(500, 2374);
        this.addWeaponToInventory(new GiantPincer());
        this.addCapability(EnemyCapabilities.CAN_USE_SKILL);
    }

    /**
     * Returns the Intrinsic Weapon of GiantCrayfish
     * @return IntrinsicWeapon of GiantCrayfish class
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(527, "claws", 100);
    }
}
