package game.action.attackactions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.enemy.Enemy;
import game.weapons.StatusEffectWeapon;
import game.weapons.statuseffect.StatusEffect;
import game.weapons.statuseffect.StatusEffectBehaviour;

/**
 * A Class for placing a status effect into play.
 * @author Jun Choi
 * @version Updated as of 18/05/2023
 */
public class StatusEffectAttackAction extends AttackAction {

    /**
     * Weapon used for the attack
     */
    private final StatusEffectWeapon weaponWithEffect;

    /**
     * target (only affects enemy class actors)
     */
    private final Enemy enemyTarget;

    /**
     * Constructor.
     *
     * @param target the Actor to attack
     * @param direction the direction where the attack should be performed (only used for display purposes)
     * @param weapon a weapon with the ability to apply status effects
     */
    public StatusEffectAttackAction(Enemy target, String direction, StatusEffectWeapon weapon) {
        super(target, direction, weapon);
        this.weaponWithEffect = weapon;
        this.enemyTarget = target;
    }

    /**
     * Perform the Action.
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return a description of what happened that can be displayed to the user.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String result = super.execute(actor,map);
        StatusEffect weaponEffect = weaponWithEffect.getStatusEffect();
        enemyTarget.setStatusEffect(new StatusEffectBehaviour(weaponEffect));

        return result;
    }

    /**
     * Returns a descriptive string
     *
     * @param actor The actor performing the action.
     * @return the text we put on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return super.menuDescription(actor) + " (applies Status Effect)";
    }
}
