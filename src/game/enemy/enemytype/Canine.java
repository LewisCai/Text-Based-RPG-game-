package game.enemy.enemytype;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.enemy.Enemy;

/**
 * Abstract Canine Class for Canine type enemies
 *
 * Created by:
 * @author Jun Choi
 * @version Updated as of 2/05/23
 */
public abstract class Canine extends Enemy {
    /**
     * Canine Enemytype Abstract Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Canine(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
    }

    /**
     * Returns the default intrinsic weapon for all canine child classes
     * @return IntrinsicWeapon of Canine class
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(97, "bites", 95);
    }
}
