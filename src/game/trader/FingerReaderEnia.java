package game.trader;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.RemembranceOfTheGrafted;
import game.action.tradeactions.ItemTradeAction;
import game.action.tradeactions.SellAction;
import game.utils.Interactions;
import game.weapons.AxeOfGodrick;
import game.weapons.GraftedDragon;
import game.weapons.Tradable;
/**
 * Class representing Merchant finger reader Enia. It extends from Actor and implements the interface Merchant.
 * Enia buys and sells different weapons and items for different prices
 * Created by:
 * @author Linjun Cai
 * @version 20/5/2023
 */
public class FingerReaderEnia extends Actor implements Merchant {

    /**
     * Constructor.
     */
    public FingerReaderEnia() {
        super("Finger Reader Enia", 'E', 0);
        this.addWeaponToInventory(new AxeOfGodrick());
        this.addWeaponToInventory(new GraftedDragon());
        this.addItemToInventory(new RemembranceOfTheGrafted());
    }

    /**
     * Adds action to the actions, so it displays on the menu
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return actions that will be displayed on menu
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if (otherActor.hasCapability(Interactions.ABLE_TO_TRADE)) {
            for (int i = 0; i < (otherActor.getWeaponInventory()).size(); i++) {
                WeaponItem currentWeapon = (otherActor.getWeaponInventory()).get(i);
                try {
                    if (((Tradable) currentWeapon).isSellable()) {
                        actions.add(new SellAction(this, currentWeapon, ((Tradable) currentWeapon).getSellPrice()));
                    }
                } catch (Exception e){
                    ;
                }
            }
            for (int i = 0; i < (otherActor.getItemInventory().size()); i++){
                Item currentItem = (otherActor.getItemInventory()).get(i);
                try {
                    //  Block of code to try
                    if(((Tradable) currentItem).isSellable()) {
                        actions.add(new ItemTradeAction(this, currentItem, 2000));
                        actions.add(new ItemTradeAction(this, currentItem, new AxeOfGodrick()));
                        actions.add(new ItemTradeAction(this, currentItem, new GraftedDragon()));
                        }
                }
                catch(Exception e) {
                    ;
                }
            }
        }
        return actions;
    }

    /**
     * What Enia does every turn
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return Enia does nothing
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }

    /**
     * Added new weapon for Enia to sell
     * @param weaponItem new weapon for Enia to sell
     */
    @Override
    public void updateMerchantInventory(WeaponItem weaponItem) {
        this.addWeaponToInventory(weaponItem);
    }
}
