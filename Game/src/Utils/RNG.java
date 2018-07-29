package Utils;

import java.util.Random;

/**
 * Created by James on 7/6/2018.
 */

public class RNG {
    private static Random random;

    public static void setSeed(long seed){
        random = new Random(seed);
    }
    public static double random(){
        return getRandom().nextDouble();
    }
    public static double random(double lower, double upper){
        double rand = random();
        rand *= (upper - lower);
        rand += lower;
        return rand;
    }

    private static Random getRandom(){
        if (random == null)
            //regular battle between human players, make the seed random
            random = new Random((long)(Math.random()*1000000));
        return random;
    }
}
