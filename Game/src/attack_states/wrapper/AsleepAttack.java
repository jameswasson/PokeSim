package attack_states.wrapper;


import attack_states.AttackState;
import attack_states.AttackWrapper;
import battle_states.pre.Asleep;
import pokemons.Pokemon;

public class AsleepAttack extends AttackWrapper {
    private boolean shouldWakeUp;

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