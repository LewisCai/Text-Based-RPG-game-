package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.weapons.weaponskills.Unsheathe;

/**
 * /**
 * A simple weapon that can be used to attack the enemy.
 * It deals 115 damage with 80% hit rate
 * Created by:
 * @author Linjun Cai
 * Modified by:
 * @author Jun Choi
 * @version 2/5/2023
 */
public class Uchigatana extends WeaponItem implements Tradable{
    /**
     * Selling price of weapon
     */
    private int sellPrice;
    /**
     * Purchasable price of weapon
     */
    private int purchasePrice;

    /**
     * public constructor of Uchigatana
     */
    public Uchigatana() {
        super("Uchigatana", ')', 115, "slashes", 80);
        this.sellPrice = 500;
        this.purchasePrice = 5000;
    }

    /**
     * Getter for getting weapon skill
     * @param target target actor
     * @param direction direction of using skill
     * @return Skill action
     */
    @Override
    public Action getSkill(Actor target, String direction) {
        return new Unsheathe(target, damage());
    }

    /**
     * Getter for sale price
     * @return integer of selling price
     */
    @Override
    public int getSellPrice() {
        return sellPrice;
    }
    /**
     * Getter for purchase price
     * @return integer of purchase price
     */
    @Override
    public int getPurchasePrice() {
        return purchasePrice;
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {}
    /**
     * Check if the weapon is Purchasable
     * @return boolean true
     */
    @Override
    public boolean isPurchasable() {
        return true;
    }

    /**
     * Check if the weapon is sellable
     * @return boolean true
     */
    @Override
    public boolean isSellable() {
        return true;
    }
}