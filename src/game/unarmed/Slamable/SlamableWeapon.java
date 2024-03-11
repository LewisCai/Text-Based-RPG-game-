package game.unarmed.Slamable;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
/**
 * Class of SlamableWeapon
 * Created by:
 * @author Jun Choi
 * @version 18/05/23
 */
public class SlamableWeapon extends WeaponItem {
    /**
     * Constructor.
     *
     * @param name        name of the item
     * @param displayChar character to use for display when item is on the ground
     * @param damage      amount of damage this weapon does
     * @param verb        verb to use for this weapon, e.g. "hits", "zaps"
     * @param hitRate     the probability/chance to hit the target.
     */
    public SlamableWeapon(String name, char displayChar, int damage, String verb, int hitRate, int radius) {
        super(name, displayChar, damage, verb, hitRate);
        this.togglePortability();
    }

    /**
     * Getter for slam action
     * @param target target actor
     * @param direction Direction of skill
     * @return Slam Action
     */
    @Override
    public Action getSkill(Actor target, String direction) {
        return new SlamAction(target, damage(), chanceToHit());
    }
}
