package game.weapons.statuseffect;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.behaviours.Behaviour;

/**
 * Behaviour class for Status Effects to take effect
 * @author Jun Choi
 * @version 20/05/2023
 */
public class StatusEffectBehaviour implements Behaviour {

    /**
     * Number of rounds the player gets affected for
     */
    private int playCount;

    /**
     * The Status Effect Action
     */
    private final Action statusEffect;

    public StatusEffectBehaviour(StatusEffect statusEffect){
        this.statusEffect = (Action) statusEffect;
        this.playCount = statusEffect.getPlayCount();
    }

    /**
     * Returns the remaining number of turns the status effect will last for
     * @return An integer
     */
    public int getRemainingPlayCount() {
        return playCount;
    }

    /**
     * Returns the status effect action
     * @param actor the Actor acting
     * @param map the GameMap containing the Actor
     * @return An Action that is the status effect
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        if (playCount >= 1){
            playCount--;
            return statusEffect;
        } else {
            return null;
        }
    }
}
