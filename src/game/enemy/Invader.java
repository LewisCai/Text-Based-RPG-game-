package game.enemy;

import game.action.archetypes.ChooseRandomClass;
import game.gamereset.ResetStatus;

/**
 * Invader Class Sus?
 * . 　　　。　　　　•　 　ﾟ　　。 　　.
 * 　　　.　　　 　　.　　　　　。　　 。　. 　
 * .　　 。　　　　　 ඞ 。 . 　　 • 　　　　
 *
 * 　　ﾟ　　 Red was An Impostor.　 。　.
 * 　　'　　　 0 Impostor remains 　 　　。
 * 　　ﾟ　　　.　　　. ,　　　　.　 .
 *
 *  Victory
 * ඞඞඞඞඞඞඞ <- Crewmates
 *
 * @Author Jun Choi
 * @Version 20/05/2023
 */
public class Invader extends Enemy {

    /**
     * Invader Constructor.
     *
     */
    public Invader() {
        super("Invader", 'ඞ', 100);
        addCapability(ResetStatus.ON_PLAYER_DEATH);
        ChooseRandomClass.chooseClass().execute(this, null);
        setRuneBoundaries(1358, 5578);
    }
}
