package attack_states.moves;

import attack_states.Move;
import pokemons.Pokemon;
import pokemons.pokemon_states.ConfusedPokemon;

public class Supersonic extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        ConfusedPokemon.tryToConfuse(opponent);
    }
}
