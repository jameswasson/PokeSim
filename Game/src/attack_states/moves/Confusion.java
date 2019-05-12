package attack_states.moves;

import attack_states.Move;
import pokemons.pokemon_states.ConfusedPokemon;
import pokemons.Pokemon;
import utils.RNG;

public class Confusion extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        super.attack(ourselves, opponent, damage);
        if (RNG.random() < .1)
            ConfusedPokemon.tryToConfuse(opponent);
    }
}
