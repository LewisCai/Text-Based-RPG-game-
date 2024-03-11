package game.action.tradeactions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.currency.RunesManager;
import game.trader.Merchant;
import game.trader.MerchantKale;

/**
 * SellAction Class
 * Created by
 * @author LinJun-Cai
 * @version 2/05/23
 */
public class SellAction extends Action{
    /**
     * Merchant who will be selling
     */
    private Merchant merchant;

    /**
     * The WeaponItem to sell
     */
    private final WeaponItem weaponItem;

    /**
     * The price to be sold at
     */
    private final int sellPrice;
    public SellAction(Merchant merchant, WeaponItem weaponItem, int sellPrice) {
        this.merchant = merchant;
        this.weaponItem = weaponItem;
        this.sellPrice = sellPrice;
    }

    /**
     * Execute the sell action by removing weapon from player and adds sell price to player's runes total
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return Message for successful selling
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        RunesManager.getRunesManagerInstance().addRunes(sellPrice);
        actor.removeWeaponFromInventory(weaponItem);
        return "Sold " + weaponItem + " for " + sellPrice;
    }

    /**
     * Returns a sentence to put on menu to display the action
     * @param actor The actor performing the action.
     * @return Message for selling action
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " sells " + weaponItem +" for " + sellPrice;
    }
}
