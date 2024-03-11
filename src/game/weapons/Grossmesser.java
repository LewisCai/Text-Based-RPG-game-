package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.weapons.weaponskills.SpinningAttack;

/**
 * Grossmesser Weapon
 *
 * Created by:
 * @author Jun Choi
 * Modified by:
 * @author Linjun Cai
 * @version Updated as of 2/05/23
 */
public class Grossmesser extends WeaponItem implements Tradable {
    /**
     * Sell price for Grossmesser
     */
    private final int sellPrice;

    /**
     * Public Grossmesser Constructor
     * No parameters required, uses predefined values
     */
    public Grossmesser() {
        super("Grossmesser", '?', 115, "slashes", 85);
        sellPrice = 100;
    }

    /**
     * Gets the available skill for the weapon
     * @return Spinning Attack action for Grossmessers
     */
    @Override
    public Action getSkill(Actor target, String direction){
        return new SpinningAttack(this.damage(), this.chanceToHit());
    }


    @Override
    public void tick(Location currentLocation, Actor actor) {}

    /**
     * Check if the weapon is sellable
     * @return true if sellable, false otherwise
     */
    @Override
    public boolean isSellable() {
        return true;
    }

    @Override
    public boolean isPurchasable() {
        return false;
    }

    /**
     * Getter for the sell price
     * @return integer of the selling price of weapon
     */
    @Override
    public int getSellPrice() {
        return sellPrice;
    }

    @Override
    public int getPurchasePrice() {
        return 0;
    }
}
