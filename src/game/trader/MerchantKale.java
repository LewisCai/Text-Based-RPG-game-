package game.trader;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.positions.GameMap;
import game.action.tradeactions.PurchaseAction;
import game.action.tradeactions.SellAction;
import game.utils.Interactions;
import game.weapons.*;
import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * Class representing Merchant Kale. It extends from Actor and implements the interface Merchant.
 * Merchant Kale buys and sells different weapons for different prices
 * Created by:
 * @author Linjun Cai
 * @version 3/5/2023
 */

public class MerchantKale extends Actor implements Merchant {

    private final Menu menu = new Menu();

    /**
     * Merchant Kale constructor
     */
    public MerchantKale(){
        super("Kale",'K',0);
        this.addWeaponToInventory(new GreatKnife());
        this.addWeaponToInventory(new Club());
        this.addWeaponToInventory(new Uchigatana());
        this.addWeaponToInventory(new Grossmesser());
        this.addWeaponToInventory(new Scimitar());
    }

    /**
     * Checks for all the actions that the player are allowed to do and return them.
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return actions the actions that are going to appear on the menu.
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if (otherActor.hasCapability(Interactions.ABLE_TO_TRADE)) {
            for (int i = 0; i < (otherActor.getWeaponInventory()).size(); i++) {
                WeaponItem currentWeapon = (otherActor.getWeaponInventory()).get(i);
                if (((Tradable) currentWeapon).isSellable()) {
                    actions.add(new SellAction(this, currentWeapon, ((Tradable) currentWeapon).getSellPrice()));
                }
            }
            for (int i = 0; i < (this.getWeaponInventory()).size(); i++) {
                WeaponItem currentWeapon = (this.getWeaponInventory()).get(i);
                if (((Tradable) currentWeapon).isPurchasable()) {
                    actions.add(new PurchaseAction(this, currentWeapon, ((Tradable) currentWeapon).getPurchasePrice()));
                }
            }
        }
        return actions;
    }

    /**
     * Update the merchant's selling or buying inventory
     * @param weaponItem weapon that's being added to the merchant inventory
     */
    @Override
    public void updateMerchantInventory(WeaponItem weaponItem) {
        this.addWeaponToInventory(weaponItem);
    }

    /**
     * The merchant can take an action at every turn
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return Action the action taken by MerchantKale
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }
}
