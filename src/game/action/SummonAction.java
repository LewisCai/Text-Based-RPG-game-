package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.enemy.EnemyCapabilities;
import game.enemy.Invader;
import game.friendly.Ally;

import java.util.List;
import java.util.Random;

/**
 * Action for summoning a guest from another realm
 *
 * @author Jun Choi
 * @version 20/05/2023
 */
public class SummonAction extends Action {

    /**
     * Location that the actor will be summoned at
     */
    private Location summonLocation;

    /**
     * Randomizer class
     */
    private Random rand = new Random();

    /**
     * Public constructor for summon action
     * @param location Location to be summoned at
     */
    public SummonAction(Location location){
        this.summonLocation = location;
    }

    /**
     * Summon a guest
     * 50% chance to be either an Ally or Invader
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return a description of what happened that can be displayed to the user.
     */
    @Override
    public String execute(Actor actor, GameMap map) {

        boolean isImposter = rand.nextInt(100) < 50;

        Actor newSummon;
        if (isImposter){
            newSummon = new Invader();
        } else {
            newSummon = new Ally();
        }


        if (!summonLocation.containsAnActor()){
            summonLocation.addActor(newSummon);
            return newSummon + " has been summoned";
        } else {
            return "Failed to summon Ally or Invader";
        }

    }

    /**
     * Returns a descriptive string
     *
     * @param actor The actor performing the action.
     * @return the text we put on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Summon a guest from another Realm";
    }
}
