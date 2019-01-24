package AttackStates.Moves;

import AttackStates.Move;
import AttackStates.Wrapper.FlinchedAttack;
import Pokemons.Pokemon;
import Utils.RNG;

public class HyperFang extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        super.attack(ourselves, opponent, damage);
        if (RNG.random() < .1)
            FlinchedAttack.makeFlinch(opponent);
    }
}
