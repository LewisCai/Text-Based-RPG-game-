package game.utils;

import java.util.Random;

/**
 * A random number generator
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class RandomNumberGenerator {
    /**
     * Get a random int
     * @param bound bound of int
     * @return random integer
     */
    public static int getRandomInt(int bound) {
        return bound > 0 ? new Random().nextInt(bound) : 0;
    }

    /**
     * Get a random integer with restricted upper and lower bound
     * @param lowerBound lowest of integer that gets generated
     * @param upperBound highest of integer that gets generated
     * @return random integer
     */
    public static int getRandomInt(int lowerBound, int upperBound) {
        int range = upperBound - lowerBound + 1;
        return new Random().nextInt(range) + lowerBound;
    }
}
