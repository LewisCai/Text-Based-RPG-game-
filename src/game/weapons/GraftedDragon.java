package game.weapons;

import edu.monash.fit2099.engine.weapons.WeaponItem;
/**
 * Weapon that can be used to attack enemy
 * Has damage of 89 and hit rate of 90
 * Created by:
 * @author Linjun Cai
 * @version 20/5/2023
 */
public class GraftedDragon extends WeaponItem implements Tradable {
    /**
     * Sell price for weapon
     */
    private int sellPrice;
    /**
     * Purchase price for weapon
     */
    private int purchasePrice;
    /**
     * Constructor.
     */
    public GraftedDragon() {
        super("Grafted Dragon", 'N', 89, "slashes", 90);
        sellPrice = 200;
    }

    /**
     * Sellable or not
     * @return boolean of weapon is sellable or not
     */
    @Override
    public boolean isSellable() {
        return false;
    }
    /**
     * Purchasable or not
     * @return boolean of weapon is purchasable or not
     */
    @Override
    public boolean isPurchasable() {
        return false;
    }

    /**
     * Getter for sell price
     * @return sell price
     */
    @Override
    public int getSellPrice() {
        return sellPrice;
    }

    /**
     * Getter for purchase price
     * @return purchase price
     */
    @Override
    public int getPurchasePrice() {
        return 0;
    }
}
