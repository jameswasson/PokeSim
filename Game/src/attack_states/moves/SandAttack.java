package attack_states.moves;

import attack_states.Move;
import pokemons.Pokemon;

public class SandAttack extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        opponent.changeACC(-1);
    }
}
