package AttackStates.Wrapper;

import AttackStates.AttackState;
import Pokemons.Pokemon;

/**
 * Created by James on 3/4/2018.
 */

public class AsleepAttack extends AttackState {
    AttackState nextAttack;
    boolean shouldWakeUp;
    public AsleepAttack(AttackState nextAttack,boolean shouldWakeUp){
        this.nextAttack = nextAttack;
        this.shouldWakeUp = shouldWakeUp;
    }
    public void execute(Pokemon us, Pokemon them){
        if (shouldWakeUp){
            logger.println(us.getName() + " woke up!");
            nextAttack.execute(us,them);
        }
        else
            logger.println(us.getName() + " is asleep!");
    }
}
