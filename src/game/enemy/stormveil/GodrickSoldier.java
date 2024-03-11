package game.enemy.stormveil;

import game.enemy.Enemy;

/**
 * GodrickSoldier class that extends from Enemy
 * The soldier of Godrick, represented by p, that has 198 hit points and carries around a ranged weapon,
 * Heavy Crossbow (see below).
 * The Heavy Crossbow will be dropped by the soldier of Godrick when they are defeated by the player.
 *
 * version 20/05/2023
 */
public class GodrickSoldier extends Enemy {

    /**
     * GodrickSoldier public constructor
     * @see Enemy
     */
    public GodrickSoldier() {
        super("GodrickSoldier", 'p',  198);
        this.setRuneBoundaries(38, 70);
    }
}
