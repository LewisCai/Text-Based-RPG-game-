package game.gamereset;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * A resettable interface
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 * @author Linjun Cai
 * @version 2/5/2023
 *
 */
public interface Resettable {
    void reset(Actor actor, GameMap map);
    void registerInManager();
}
