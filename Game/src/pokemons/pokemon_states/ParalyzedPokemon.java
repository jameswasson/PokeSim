package pokemons.pokemon_states;

import battle_states.BattleState;
import pokemons.Pokemon;
import pokemons.WrapperPokemon;
import utils.RNG;

public class ParalyzedPokemon extends WrapperPokemon {
    @Override
    public void attack(Pokemon toAttack) {
        if (RNG.random() < 0.25)
            logger.println(getName() + " is paralyzed! It can't move!");
        else
            super.attack(toAttack);
    }

    public static boolean isParalyzed(Pokemon pokemon) {
        return pokemon.containsState(ParalyzedPokemon.class);
    }

    public static void tryToParalyze(Pokemon pokemon) {
        if (isParalyzed(pokemon)) {
            logger.println(pokemon.getName() + " is already paralyzed!");
        } else if (BattleState.isNonVolatile(pokemon)) {
            logger.println("But it failed!");
        } else {
            logger.println(pokemon.getName() + " is paralyzed! It can't move!");
            WrapperPokemon.wrap(pokemon, new ParalyzedPokemon());
        }
    }
}
