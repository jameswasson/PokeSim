package attack_states.moves;

import attack_states.Move;
import battle_states.pre.Asleep;
import pokemons.Pokemon;

public class Sing extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        Asleep.tryToPutToSleep(opponent);
    }
}
