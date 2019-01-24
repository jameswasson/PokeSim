package attack_states.moves;

import attack_states.Move;
import pokemons.Pokemon;

public class Amnesia extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        ourselves.changeSPC(2);
    }
}
