package game.ground;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;
import game.action.DeathRestAction;

/**
 *  It is represented as +. It kills the player when the player is on the cliff.
 *  version 20/05/2021
 */
public class Cliff extends Ground {

    /**
     * Cliff public constructor
     * @see Ground
     */
    public Cliff() {
        super('+');
    }

    /**
     * Tick method for the Cliff when the player is on the cliff it will kill the player
     * @param location The location of the Ground
     */
    public void tick(Location location){
        if(location.containsAnActor()){
            Actor actor = location.getActor();
            if(actor.hasCapability(Status.PLAYER)){
                DeathRestAction deathAction = new DeathRestAction();
                deathAction.execute(actor, location.map());
            }
        }
    }
}
