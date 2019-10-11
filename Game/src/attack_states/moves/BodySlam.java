package attack_states.moves;

import attack_states.Move;
import pokemons.Pokemon;
import pokemons.pokemon_states.ParalyzedPokemon;
import utils.RNG;

public class BodySlam extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        super.attack(ourselves, opponent, damage);
        if (RNG.random() < .3)
            ParalyzedPokemon.tryToParalyze(opponent);
    }
}
