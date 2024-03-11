package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import game.weapons.statuseffect.PoisonAction;
import game.weapons.statuseffect.StatusEffect;

/**
 * Poison Dagger, a small yet fearful blade that poisons its enemies.
 * @author Jun Choi
 * @version Updated as of 18/05/2023
 */
public class PoisonDagger extends StatusEffectWeapon{
    /**
     * Constructor.
     *
     */
    public PoisonDagger() {
        super("Poison Dagger", ';', 100, "stabs", 95);
    }

    /**
     * The action of the status effect
     * @return Statu Effect Action
     */
    @Override
    public StatusEffect getStatusEffect() {
        return new PoisonAction();
    }
}
