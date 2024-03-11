package game.ground;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;

/**
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 *
 */
public class Wall extends Ground {
	/**
	 * Constructor
	 */
	public Wall() {
		super('#');
	}

	/**
	 * Return boolean for if actor can enter
	 * @param actor the Actor to check
	 * @return False, no one can enter
	 */
	@Override
	public boolean canActorEnter(Actor actor) {
		return false;
	}

	/**
	 * Whether this ground blocks thrown objects
	 * @return true, it does block thrown objects
	 */
	@Override
	public boolean blocksThrownObjects() {
		return true;
	}
}
