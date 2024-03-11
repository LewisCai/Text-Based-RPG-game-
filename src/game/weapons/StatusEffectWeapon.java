package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.weapons.statuseffect.EffectCapability;
import game.weapons.statuseffect.StatusEffect;

/**
 * Status Effect Weapon Class
 * Abstract WeaponItem subclass for Weapons with Status effects
 * @author Jun Choi
 * @version 20/05/2023
 */
public abstract class StatusEffectWeapon extends WeaponItem {

    /**
     * Constructor.
     *
     * @param name        name of the item
     * @param displayChar character to use for display when item is on the ground
     * @param damage      amount of damage this weapon does
     * @param verb        verb to use for this weapon, e.g. "hits", "zaps"
     * @param hitRate     the probability/chance to hit the target.
     */
    public StatusEffectWeapon(String name, char displayChar, int damage, String verb, int hitRate) {
        super(name, displayChar, damage, verb, hitRate);
        this.addCapability(EffectCapability.HAS_STATUS_EFFECT);
    }

    public StatusEffect getStatusEffect(){
        return null;
    }
}
