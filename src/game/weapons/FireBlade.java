package game.weapons;

import game.weapons.statuseffect.BurnAction;
import game.weapons.statuseffect.StatusEffect;

/**
 * Fire Blade, a powerful sword that burns with the power of the sun
 * @author Jun Choi
 * @version Updated as of 18/05/2023
 */
public class FireBlade extends StatusEffectWeapon {

    /**
     * FireBlade Constructor
     */
    public FireBlade(){
        super("FireBlade", 'F', 150, "slashes", 95);
    }

    /**
     * Returns the Status Effect Action
     * @return Action Status Effect
     */
    @Override
    public StatusEffect getStatusEffect() {
        return new BurnAction();
    }
}
