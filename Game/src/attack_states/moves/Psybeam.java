package attack_states.moves;

import attack_states.Move;
import pokemons.Pokemon;
import pokemons.pokemon_states.ConfusedPokemon;
import utils.RNG;

public class Psybeam extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        super.attack(ourselves, opponent, damage);
        if (RNG.random() < .1)
            ConfusedPokemon.tryToConfuse(ourselves);
    }
}
