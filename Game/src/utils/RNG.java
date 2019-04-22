package utils;

import java.util.Random;

public class RNG {
    private RNG() {
    }

    private static Random random;

    public static void setSeed(long seed) {
        random = new Random(seed);
    }

    public static double random() {
        return getRandom().nextDouble();
    }

    public static double random(double lower, double upper) {
        double rand = random();
        rand *= (upper - lower);
        rand += lower;
        return rand;
    }

    public static int randomInt(int lower, int upper) {
        //upper and lower are both inclusive
        double rand = random((double) lower, (double) ++upper);
        return (int) rand;
    }

    private static Random getRandom() {
        if (random == null)
            //regular battle between human players, make the seed random
            setSeed((long) (Math.random() * 1000000));
        return random;
    }
}
