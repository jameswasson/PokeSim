package attack_states.moves;

import attack_states.Move;
import pokemons.Pokemon;

public class SuperFang extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        super.attack(ourselves, opponent, Math.max(1, opponent.getCurHP()));
    }
}
