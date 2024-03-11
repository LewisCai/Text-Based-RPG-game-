package game.weapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * A simple weapon that can be used to attack the enemy.
 * It deals 103 damage with 80% hit rate
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 * @author Linjun Cai
 */
public class Club extends WeaponItem implements Tradable {
    /**
     * Sell price for weapon
     */
    private int sellPrice;
    /**
     * Purchase price for weapon
     */
    private int purchasePrice;
    /**
     * Constructor
     */
    public Club() {
        super("Club", '!', 103, "bonks", 80);
        sellPrice = 100;
        purchasePrice = 600;
    }

    /**
     * Getter for sale price
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
        return purchasePrice;
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {}

    /**
     * If the weapon is purchasable
     * @return true, yes it is purchasable
     */
    @Override
    public boolean isPurchasable() {
        return true;
    }
    /**
     * If the weapon is sellable
     * @return true, yes it is sellable
     */
    @Override
    public boolean isSellable() {
        return true;
    }
}
