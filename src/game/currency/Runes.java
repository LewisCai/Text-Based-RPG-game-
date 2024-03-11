package game.currency;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.items.DropItemAction;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.action.DropRunesAction;
import game.action.PickUpRunesAction;
import game.gamereset.ResetManager;
import game.gamereset.Resettable;

import java.util.List;

/**
 * Class of runes that extends from item
 */
public class Runes extends Item{
    /**
     * The value of runes
     */
    private int value;
    /***
     * Runes constructor
     */
    public Runes(int value) {
        super("Runes", '$', true);
        this.value = value;
    }

    /**
     * Factory method to get instance of runes
     * @return Instance of runes
     */

    @Override
    public PickUpAction getPickUpAction(Actor actor) {
        return new PickUpRunesAction(this);
    }

    @Override
    public DropAction getDropAction(Actor actor) {
        return new DropRunesAction(this);
    }


    /**
     * Setter for value
     * @param value Runes value
     */
    public void setValue(int value){
        this.value = value;
    }

    /**
     * Getter for value
     * @return value Current Rune value
     */

    public int getValue(){
        return this.value;
    }

}
