package attack_states.moves;

import attack_states.Move;
import pokemons.Pokemon;

public class DefenseCurl extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        ourselves.changeDEF(1);
    }
}
