package attack_states.moves;

import attack_states.Move;
import pokemons.FlinchedPokemon;
import pokemons.Pokemon;
import utils.RNG;

public class Stomp extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        super.attack(ourselves, opponent, damage);
        if (RNG.random() < .3)
            FlinchedPokemon.makeFlinch(opponent);
    }
}
