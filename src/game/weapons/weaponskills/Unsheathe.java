package game.weapons.weaponskills;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.action.DeathAction;

import java.util.Random;

public class Unsheathe extends Action {

    private final int damage;
    private final Actor target;
    Random rand = new Random();

    public Unsheathe(Actor target, int damage) {
        this.damage = damage;
        this.target = target;
    }

    /**
     * Perform Unsheathe.
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return a description of what happened that can be displayed to the user.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String result = "";
        int hitSuccess = rand.nextInt(100);
        if (hitSuccess <= 60){
            target.hurt(damage*2);
            result += target + " was slashed by " + actor;
        }
        if (!target.isConscious()) {
            result += new DeathAction(actor).execute(target, map);
        }
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
        return actor + " uses Unsheathe";
    }
}