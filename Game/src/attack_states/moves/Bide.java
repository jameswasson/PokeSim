package attack_states.moves;

import attack_states.Move;
import pokemons.Pokemon;

public class Bide extends Move {
    @Override
    protected boolean willMiss(Pokemon ourselves, Pokemon opponent) {
        return true;
    }
    //todo, code not finished yet
}
