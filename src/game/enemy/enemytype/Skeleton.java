package game.enemy.enemytype;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.enemy.Enemy;
import game.enemy.EnemyCapabilities;
//import game.unarmed.pileofbones.PileOfBoneAction;
import game.unarmed.PileOfBoneActor;
//import game.unarmed.pileofbones.PileOfBoneBehaviour;

/**
 * Abstract Skeleton Class for Skeleton type enemies
 *
 * Created by:
 * @author Jun Choi
 * @version Updated as of 2/05/23
 */
public abstract class Skeleton extends Enemy {
    /**
     * Skeleton Enemytype Abstract Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     * @param weaponItem  the weapon the skeleton wields, can be null if they do not wield
     */
    public Skeleton(String name, char displayChar, int hitPoints, WeaponItem weaponItem) {
        super(name, displayChar, hitPoints);
        this.addWeaponToInventory(weaponItem);
//        this.behaviours.put(DEATH_PASSIVE_KEY, new PileOfBoneBehaviour(this));
        this.addCapability(EnemyCapabilities.DEATH_PASSIVE);
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        Action action = super.playTurn(actions, lastAction, map, display);
        if (!this.isConscious()){
            Location skeletonLocation = map.locationOf(this);
            this.heal(99999);
            int x = skeletonLocation.x();
            int y = skeletonLocation.y();
            map.removeActor(this);
            map.at(x,y).addActor(new PileOfBoneActor(this));
            return new DoNothingAction();
        }
        return action;
    }

    /**
     * Returns the default intrinsic weapon for all Skeleton child classes
     * @return IntrinsicWeapon of Skeleton class
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(40, "punch", 75);
    }
}
