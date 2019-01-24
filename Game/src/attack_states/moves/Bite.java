package attack_states.moves;

import attack_states.Move;
import attack_states.wrapper.FlinchedAttack;
import pokemons.Pokemon;
import utils.RNG;

public class Bite extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        super.attack(ourselves, opponent, damage);
        if (RNG.random() < .1)
            FlinchedAttack.makeFlinch(opponent);
    }
}