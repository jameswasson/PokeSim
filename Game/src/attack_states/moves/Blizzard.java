package attack_states.moves;

import attack_states.Move;
import pokemons.Pokemon;
import pokemons.pokemon_states.FrozenPokemon;
import utils.RNG;

public class Blizzard extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        super.attack(ourselves, opponent, damage);
        if (moveRNG.moveWillApplyStatus(.1))
            FrozenPokemon.tryToFreeze(opponent);
    }
}
