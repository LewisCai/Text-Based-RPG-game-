package game.action.tradeactions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.currency.RunesManager;
import game.trader.Merchant;
/**
 * Trade action for item
 * Created by:
 * @author Linjun Cai
 * @version 20/5/2023
 */
public class ItemTradeAction extends Action {
    /**
     * Merchant class
     */
    private Merchant merchant;

    /**
     * The WeaponItem to sell
     */
    private Item item;
    /**
     * Instance of weaponItem
     */
    private WeaponItem weaponItem = null;

    /**
     * The price to be sold at
     */
    private int sellPrice = 0;

    /**
     * Constructor
     * @param merchant merchant that's trading
     * @param item item to be traded
     * @param sellPrice price of the item
     */
    public ItemTradeAction(Merchant merchant, Item item, int sellPrice) {
        this.merchant = merchant;
        this.item = item;
        this.sellPrice = sellPrice;
    }

    /**
     * Another constructor for weapon
     * @param merchant merchant that's trading
     * @param item item to be traded
     * @param weaponItem weapon to be traded
     */
    public ItemTradeAction(Merchant merchant, Item item, WeaponItem weaponItem) {
        this.merchant = merchant;
        this.item = item;
        this.weaponItem = weaponItem;
    }

    /**
     * Execute the sell action by removing weapon from player and adds sell price to player's runes total
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return Message for successful selling
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (weaponItem != null) {
            actor.removeItemFromInventory(item);
            actor.addWeaponToInventory(weaponItem);
            return "Trade " + item + " for " + weaponItem;
        }
        RunesManager.getRunesManagerInstance().addRunes(sellPrice);
        actor.removeItemFromInventory(item);
        return "Trade " + item + " for " + sellPrice;
    }

    /**
     * Returns a sentence to put on menu to display the action
     * @param actor The actor performing the action.
     * @return Message for selling action
     */
    @Override
    public String menuDescription(Actor actor) {
        if (weaponItem != null) {
            return actor + " trades " + item +" for " + weaponItem;
        }
        return actor + " trades " + item +" for " + sellPrice;
    }
}