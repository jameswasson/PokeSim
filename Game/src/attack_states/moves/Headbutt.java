package attack_states.moves;

import attack_states.Move;
import pokemons.Pokemon;
import pokemons.pokemon_states.FlinchedPokemon;
import utils.RNG;

public class Headbutt extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        super.attack(ourselves, opponent, damage);
        if (RNG.random() < .3)
            FlinchedPokemon.makeFlinch(opponent);
    }
}
