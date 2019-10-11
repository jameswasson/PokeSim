package attack_states.moves;

import attack_states.Move;
import pokemons.Pokemon;

public class Swift extends Move {
    @Override
    public boolean willMiss(Pokemon ourselves, Pokemon opponent) {
        return false;
    }
}