package attack_states.moves;

import attack_states.Move;
import pokemons.Pokemon;

public class NightShade extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        super.attack(ourselves, opponent, opponent.getLevel());
    }
    //todo
}
