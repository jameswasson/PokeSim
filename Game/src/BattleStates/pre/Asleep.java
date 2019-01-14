package BattleStates.pre;

import AttackStates.AttackState;
import AttackStates.Wrapper.AsleepAttack;
import BattleStates.BattleState;
import Pokemons.Pokemon;
import Utils.RNG;

public class Asleep extends BattleState {
    public int turnsAsleep;

    public Asleep(int turnsAsleep) {
        this.turnsAsleep = turnsAsleep;
    }

    public void execute(Pokemon pokemon) {
        AttackState nextAttack = pokemon.getAttackState();
        boolean shouldWakeUp = turnsAsleep <= 0;
        pokemon.setAttackState(new AsleepAttack(nextAttack, shouldWakeUp));
        turnsAsleep--;
    }

    public static void tryToPutToSleep(Pokemon pokemon) {
        tryToPutToSleep(pokemon, RNG.randomInt(1, 3));
    }

    public static void tryToPutToSleep(Pokemon pokemon, int turnsAsleep) {
        if (isAsleep(pokemon)) {
            logger.println(pokemon.getName() + " is already asleep!");
        } else if (isNonVolatile(pokemon)) {
            logger.println("But it failed!");
        } else {
            logger.println(pokemon.getName() + " fell asleep!");
            BattleState asleep = new Asleep(turnsAsleep);
            pokemon.getPreBattleStates().add(asleep);
            asleep.execute(pokemon);
        }
    }

    public static boolean isAsleep(Pokemon pokemon) {
        return new Asleep(0).containsState(pokemon);
    }

    public static void wakeUp(Pokemon pokemon) {
        new Asleep(0).removeState(pokemon);
    }
}