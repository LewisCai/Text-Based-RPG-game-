package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Status;
import game.action.attackactions.AttackAction;
import game.action.WeaponSkillAction;
import game.enemy.EnemyCapabilities;

import java.util.List;

public class FriendlyAttackBehaviour implements Behaviour{
    /**
     * A factory for creating actions. Chaining these together can result in an actor performing more complex tasks.
     * @param actor the Actor acting
     * @param map   the GameMap containing the Actor
     * @return an Action that actor can perform, or null if actor can't do this.
     * @author Jun Choi
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        Location allyLocation = map.locationOf(actor);

        List<Exit> allyExits = allyLocation.getExits();

        Actor enemyTarget = null;
        for(Exit exit : allyExits){
            Location exitLocation = exit.getDestination();
            Actor current = exitLocation.getActor();
            if (current.hasCapability(EnemyCapabilities.ENEMY)){
                enemyTarget = exitLocation.getActor();
                break;
            }
        }
        if (enemyTarget == null){
            return null;
        }

        WeaponItem weapon;
        try {
            weapon = actor.getWeaponInventory().get(0);

        }
        catch (Exception e){
            weapon = null;
        }
        return new AttackAction(enemyTarget, "attackDirection", weapon);
    }
}
