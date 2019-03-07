package attack_states.wrapper;

import pokemons.FlinchedPokemon;
import pokemons.Pokemon;
import pokemons.WrapperPokemon;

public class Flinch {
    public static boolean isFlinched(Pokemon pokemon) {
        return WrapperPokemon.containsWrapped(pokemon, FlinchedPokemon.class);
    }

    public static void makeFlinch(Pokemon pokemon) {
        if (!isFlinched(pokemon)) {
            WrapperPokemon.wrap(pokemon, new FlinchedPokemon());
        }
    }
}
