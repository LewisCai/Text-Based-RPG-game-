package game.enemy.stormveil;

import game.enemy.Enemy;

/**
 * Dog class that extends from Enemy
 */
public class Dog extends Enemy {


    /**
     * Dog public constructor
     * @see Enemy
     */
    public Dog() {
        super("Dog", 'a', 101);
        this.setRuneBoundaries(52, 1390);
    }

}
