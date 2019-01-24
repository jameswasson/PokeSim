package AttackStates.Wrapper;

import AttackStates.AttackState;
import AttackStates.AttackWrapper;
import BattleStates.pre.Asleep;
import Pokemons.Pokemon;


public class AsleepAttack extends AttackWrapper {
    boolean shouldWakeUp;

    public AsleepAttack(AttackState nextAttack, boolean shouldWakeUp) {
        this.nextAttack = nextAttack;
        this.shouldWakeUp = shouldWakeUp;
    }

    public void execute(Pokemon us, Pokemon them) {
        if (shouldWakeUp) {
            Asleep.wakeUp(us);
            logger.println(us.getName() + " woke up!");
            nextAttack.execute(us, them);
        } else
            logger.println(us.getName() + " is asleep!");
    }


}