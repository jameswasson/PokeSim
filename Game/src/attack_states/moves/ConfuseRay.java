package attack_states.moves;

import attack_states.Move;
import pokemons.pokemon_states.ConfusedPokemon;
import pokemons.Pokemon;

public class ConfuseRay extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        ConfusedPokemon.tryToConfuse(opponent);
    }
}
