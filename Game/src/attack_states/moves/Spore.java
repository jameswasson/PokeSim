package attack_states.moves;

import attack_states.Move;
import pokemons.Pokemon;
import pokemons.SleepingPokemon;

public class Spore extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        SleepingPokemon.tryToPutToSleep(opponent);
    }
}
