package attack_states.moves;

import attack_states.Move;
import pokemons.Pokemon;
import pokemons.pokemon_states.SleepingPokemon;

public class LovelyKiss extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        SleepingPokemon.tryToPutToSleep(opponent);
    }
}
