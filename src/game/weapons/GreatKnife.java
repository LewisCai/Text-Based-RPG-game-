package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.weapons.weaponskills.Quickstep;
/**
 * A simple weapon that can be used to attack the enemy.
 * It deals 75 damage with 70% hit rate
 * Created by:
 * @author Linjun Cai
 * Modified by:
 * @author Jun Choi
 * @version 2/5/2023
 */
public class GreatKnife extends WeaponItem implements Tradable {
    /**
     * Selling price for the weapon
     */
    private int sellPrice;
    /**
     * Purchase price for the weapon
     */
    private int purchasePrice;

    /**
     * Constructor for GreatKnife
     */
    public GreatKnife() {
        super("GreatKnife", '/', 75, "slashes", 70);
        sellPrice = 350;
        purchasePrice = 3500;
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

    /**
     * Getter for getting weapon skill
     * @param target target actor
     * @param direction direction of using skill
     * @return Skill action
     */
    @Override
    public Action getSkill(Actor target, String direction) {
        return new Quickstep(target, direction, this);
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {
    }

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