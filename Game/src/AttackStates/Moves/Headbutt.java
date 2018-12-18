package AttackStates.Moves;

import AttackStates.Move;
import AttackStates.Wrapper.FlinchedAttack;
import Pokemons.Pokemon;
import Utils.RNG;

public class Headbutt extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        super.attack(ourselves, opponent, damage);
        if (RNG.random() < .3)
            FlinchedAttack.makeFlinch(opponent);
    }
}
