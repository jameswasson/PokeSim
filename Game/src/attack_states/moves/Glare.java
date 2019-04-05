package attack_states.moves;

import attack_states.Move;
import pokemons.ParalyzedPokemon;
import pokemons.Pokemon;

public class Glare extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        ParalyzedPokemon.tryToParalyze(opponent);
    }
}
