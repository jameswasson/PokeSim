package attack_states.moves;

import attack_states.Move;
import pokemons.Pokemon;
import utils.RNG;

public class AuroraBeam extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        super.attack(ourselves, opponent, damage);
        if (RNG.random() < .33)
            opponent.changeATK(-1);
    }
}
