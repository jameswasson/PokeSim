package pokemons.pokemon_states;

import battle_states.BattleState;
import pokemons.Pokemon;
import pokemons.WrapperPokemon;
import utils.RNG;

public class SleepingPokemon extends WrapperPokemon {
    private int turnsTillAwake;

    private SleepingPokemon(int turnsTillAwake) {
        this.turnsTillAwake = turnsTillAwake;
    }

    @Override
    public void runPostBattleStates() {
        turnsTillAwake--;
        super.runPostBattleStates();
    }

    @Override
    public void attack(Pokemon toAttack) {
        if (turnsTillAwake <= 0) {
            logger.println(getName() + " woke up!");
            removeSelf();
            super.attack(toAttack);
        }
        else{
            logger.println(getName() + " is asleep!");
        }
    }

    public static boolean isAsleep(Pokemon pokemon){
        return WrapperPokemon.containsWrapped(pokemon, SleepingPokemon.class);
    }

    public static void tryToPutToSleep(Pokemon pokemon, int turnsAsleep){
        if (isAsleep(pokemon))
            logger.println(pokemon.getName() + " is already asleep!");
        else if (BattleState.isNonVolatile(pokemon))
            logger.println("But it failed!");
        else{
            logger.println(pokemon.getName() + " fell asleep!");
            WrapperPokemon.wrap(pokemon, new SleepingPokemon(turnsAsleep));
        }
    }

    public static void tryToPutToSleep(Pokemon pokemon) {
        tryToPutToSleep(pokemon, RNG.randomInt(1, 3));
    }
}
