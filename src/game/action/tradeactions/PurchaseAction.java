package game.action.tradeactions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.currency.RunesManager;
import game.trader.Merchant;

/**
 * Action for player to purchase weapon from merchant
 *
 * @author Linjun Cai
 * @version 2/5/2023
 */

public class PurchaseAction extends Action{
    /**
     * Merchant that the player can purchase weapon from
     */
    private Merchant merchant;
    /**
     * Weapon that player can purchase from the merchant
     */
    private WeaponItem weaponItem;
    /**
     * Price of weapon
     */
    private int purchasePrice;

    /**
     * Constructor for PurchaseAction
     *
     * @param merchant The merchant player is buying weapon from
     * @param weaponItem The weapon player wants to buy
     * @param purchasePrice Price of the weapon
     */
    public PurchaseAction(Merchant merchant, WeaponItem weaponItem, int purchasePrice){
        this.merchant = merchant;
        this.weaponItem = weaponItem;
        this.purchasePrice = purchasePrice;
    }

    /**
     * Executes the buying action, check conditions if player has enough runes to purchase the weapon.
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return A message indicates a failed or successful purchase.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if(RunesManager.getRunesManagerInstance().getCurrentPlayerRunes() < purchasePrice){
            return "Not enough runes to purchase "+ weaponItem+".";
        } else{
            RunesManager.getRunesManagerInstance().removeRunes(purchasePrice);
            actor.addWeaponToInventory(weaponItem);
            return "Successfully purchased "+ weaponItem+ "!";
        }
    }

    /**
     * Description for the action
     *
     * @param actor The actor performing the action.
     * @return Message of action to display on menu.
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor +" purchase " + weaponItem + " for " + purchasePrice;
    }

}
