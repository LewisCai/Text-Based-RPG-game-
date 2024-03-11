package game;

import edu.monash.fit2099.engine.items.Item;
import game.weapons.Tradable;
/**
 * Class of remembrance of the grafted, extends from item and implements tradable
 * Created by:
 * @author Linjun Cai
 * @version 20/5/2023
 */
public class RemembranceOfTheGrafted extends Item implements Tradable {
    /***
     * Constructor.
     */
    public RemembranceOfTheGrafted() {
        super("Remembrance of the Grafted", 'O', true);
    }

    @Override
    public boolean isSellable() {
        return true;
    }

    @Override
    public boolean isPurchasable() {
        return false;
    }

    @Override
    public int getSellPrice() {
        return 2000;
    }

    @Override
    public int getPurchasePrice() {
        return 0;
    }
}
