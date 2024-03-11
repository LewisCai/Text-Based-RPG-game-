package game.weapons;

/**
 * Interface of sellable
 *
 * Created by:
 * @author Linjun Cai
 * @version 2/5/2023
 */
public interface Tradable {
    public boolean isSellable();
    public boolean isPurchasable();
    public int getSellPrice();
    public int getPurchasePrice();
}
