package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Status;
import game.currency.RunesManager;
import game.enemy.Enemy;
import game.enemy.EnemyCapabilities;

/**
 * An action executed if an actor is killed.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 * Jun Choi
 *
 */
public class DeathAction extends Action {
    private Actor attacker;

    public DeathAction(Actor actor) {
        this.attacker = actor;
    }

    /**
     * When the target is killed, the items & weapons carried by target
     * will be dropped to the location in the game map where the target was
     *
     * @param target The actor performing the action.
     * @param map The map the actor is on.
     * @return result of the action to be displayed on the UI
     */
    @Override
    public String execute(Actor target, GameMap map) {
        String result = "";
        if(target.hasCapability(Status.ALIVE)){
            result += new DeathRestAction().execute(target, map);
            return result;
        }

        if (target.hasCapability(EnemyCapabilities.DEATH_PASSIVE)){
            return result;
        }

        if (target.hasCapability(EnemyCapabilities.ENEMY) && !attacker.hasCapability(EnemyCapabilities.ENEMY)){
            Enemy defeatedEnemy = (Enemy) target;
            int runeValue = defeatedEnemy.runeDropNumber();
            RunesManager.getRunesManagerInstance().addRunes(runeValue);
        }

        ActionList dropActions = new ActionList();
        // drop all items
        for (Item item : target.getItemInventory())
            dropActions.add(item.getDropAction(target));
        for (WeaponItem weapon : target.getWeaponInventory())
            dropActions.add(weapon.getDropAction(target));
        for (Action drop : dropActions)
            drop.execute(target, map);
        // remove actor
        map.removeActor(target);
        result += System.lineSeparator() + menuDescription(target);
        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " is killed.";
    }
}
