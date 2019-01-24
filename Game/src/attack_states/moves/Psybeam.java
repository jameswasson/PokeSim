package attack_states.moves;

import attack_states.Move;
import battle_states.pre.Confused;
import pokemons.Pokemon;
import utils.RNG;

public class Psybeam extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        super.attack(ourselves, opponent, damage);
        if (RNG.random() < .1)
            Confused.tryToConfuse(ourselves);
    }
}
