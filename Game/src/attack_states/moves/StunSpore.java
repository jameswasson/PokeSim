package attack_states.moves;

import attack_states.Move;
import pokemons.pokemon_states.ParalyzedPokemon;
import pokemons.Pokemon;

public class StunSpore extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        ParalyzedPokemon.tryToParalyze(opponent);
    }
}
