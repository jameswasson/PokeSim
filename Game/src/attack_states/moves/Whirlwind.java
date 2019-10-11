package attack_states.moves;

import attack_states.Move;
import pokemons.Pokemon;

public class Whirlwind extends Move {
    @Override
    protected boolean willMiss(Pokemon ourselves, Pokemon opponent) {
        return true;
        //This move always fails, ha
    }
}
