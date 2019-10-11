package attack_states.moves;

import attack_states.Move;
import pokemons.Pokemon;
import pokemons.pokemon_states.TransformedPokemon;

//If a transformed pokemon receives a critical hit, it's original stats are used, this requires a wrapper.
public class Transform extends Move {
    @Override
    protected boolean willMiss(Pokemon ourselves, Pokemon opponent) {
        return false;
    }

    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        TransformedPokemon.transform(ourselves, opponent);
        logger.println(ourselves.getName() + " Transformed into " + opponent.getName() + "!");
    }
}