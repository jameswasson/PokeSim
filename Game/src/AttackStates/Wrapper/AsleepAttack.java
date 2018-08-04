package AttackStates.Wrapper;

import AttackStates.AttackState;
import AttackStates.AttackWrapper;
import Pokemons.Pokemon;


public class AsleepAttack extends AttackWrapper {
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