package game.action;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
/**
 * WeaponSkill Action Class
 * Created by
 * @author Jun Choi
 * @version 2/05/23
 */
public class WeaponSkillAction extends Action {

    /**
     * The target Actor who will receive the blow
     */
    private final Actor target;

    /**
     * A string describing which direction the skill is used in
     */
    private String direction;

    /**
     * The WeaponItem used
     */
    private WeaponItem weaponItem;

    /**
     * Public constructor for WeaponSkillAction class
     * @param target The Actor receiving the effects
     * @param direction Description of direction
     * @param weaponItem WeaponItem with the skill used
     */
    public WeaponSkillAction(Actor target, String direction, WeaponItem weaponItem){
        this.target = target;
        this.direction = direction;
        this.weaponItem = weaponItem;
    }

    /**
     * Perform the Weapon's Skill.
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return a description of what happened that can be displayed to the user.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String result = "";
        Action weaponSkill = weaponItem.getSkill(target, direction);
        result += weaponSkill.execute(actor, map);
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
        return weaponItem.getSkill(target, direction).menuDescription(actor) + " against " + target;
    }
}
