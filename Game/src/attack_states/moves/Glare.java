package attack_states.moves;

import attack_states.Move;
import pokemons.Pokemon;
import pokemons.pokemon_states.ParalyzedPokemon;

public class Glare extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        ParalyzedPokemon.tryToParalyze(opponent);
    }
}
