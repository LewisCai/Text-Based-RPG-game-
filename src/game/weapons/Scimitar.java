package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.weapons.weaponskills.SpinningAttack;

/**
 * Scimitar Weapon
 *
 * Created by:
 * @author Jun Choi
 * Modified by:
 * @author Linjun Cai
 * @version Updated as of 2/05/23
 */
public class Scimitar extends WeaponItem implements Tradable {
    /**
     * Purchase price of Scimitar
     */
    private final int purchasePrice;
    /**
     * Selling price of Scimitar
     */
    private final int sellPrice;

    /**
     * Constructor.
     *
     */
    public Scimitar() {
        super("Scimitar", 's', 118, "slashes", 88);
        purchasePrice = 600;
        sellPrice = 100;
    }

    /**
     * Checks if a weapon is purchasable
     * @return true if purchasable false otherwise
     */
    @Override
    public boolean isPurchasable() {
        return true;
    }

    /**
     * Getter for purchase price of the weapon
     * @return integer of purchase price
     */
    @Override
    public int getPurchasePrice() {
        return purchasePrice;
    }
    /**
     * Checks if a weapon is sellable
     * @return true if sellable false otherwise
     */
    @Override
    public boolean isSellable() {
        return true;
    }

    /**
     * Getter for selling price of the weapon
     * @return integer of selling price
     */
    @Override
    public int getSellPrice() {
        return sellPrice;
    }

    /**
     * Gets the available skill for the weapon
     *
     * @return Spinning Attack action for Grossmessers
     */
    @Override
    public Action getSkill(Actor target, String direction){
        return new SpinningAttack(this.damage(), this.chanceToHit());
    }
}
