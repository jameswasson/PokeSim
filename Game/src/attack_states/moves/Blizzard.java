package attack_states.moves;

import attack_states.Move;
import battle_states.pre.Frozen;
import pokemons.Pokemon;
import utils.RNG;

public class Blizzard extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        super.attack(ourselves, opponent, damage);
        if (RNG.random() < .1)
            Frozen.tryToFreeze(opponent);
    }
}
