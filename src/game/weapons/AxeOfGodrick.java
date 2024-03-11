package game.weapons;

import edu.monash.fit2099.engine.weapons.WeaponItem;
/**
 * A simple weapon that can be used to attack the enemy.
 * It deals 142 damage with 84% hit rate
 * Created by:
 * @author Linjun Cai
 * @version 20/5/2023
 */
public class AxeOfGodrick extends WeaponItem implements Tradable{
    /**
     * Price for selling
     */
    private int sellPrice;
    /**
     * Purchase price for weapon
     */
    private int purchasePrice;
    /**
     * Constructor.
     */
    public AxeOfGodrick() {
        super("Axe of Godrick", 'T', 142, "slashes", 84);
        sellPrice = 100;
    }

    /**
     * Sellable or not
     * @return boolean of weapon is sellable or not
     */
    @Override
    public boolean isSellable() {
        return true;
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
