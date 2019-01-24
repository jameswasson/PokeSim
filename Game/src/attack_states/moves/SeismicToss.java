package attack_states.moves;

import attack_states.Move;
import pokemons.Pokemon;

public class SeismicToss extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        new NightShade().attack(ourselves, opponent, damage);
    }
    //todo
}
