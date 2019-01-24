package attack_states.moves;

import attack_states.Move;
import pokemons.Pokemon;

public class Whirlwind extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        logger.println("But it failed!");
        //This move always fails, ha
    }
}
