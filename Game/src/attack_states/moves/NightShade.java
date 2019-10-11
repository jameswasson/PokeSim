package attack_states.moves;

import attack_states.Move;
import pokemons.Pokemon;

public class NightShade extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        super.attack(ourselves, opponent, opponent.getLevel());
    }

    @Override
    public boolean noEffect(Pokemon opponent) {
        return false;
    }
}
