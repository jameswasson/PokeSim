package attack_states.moves;

import attack_states.Move;
import pokemons.Pokemon;

public class Splash extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        logger.println("But nothing happened!");
    }
}
