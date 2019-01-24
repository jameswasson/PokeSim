package AttackStates.Moves;

import AttackStates.Move;
import BattleStates.pre.Confused;
import Pokemons.Pokemon;
import Utils.RNG;

public class Confusion extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        super.attack(ourselves, opponent, damage);
        if (RNG.random() < .1)
            Confused.tryToConfuse(opponent);
    }
}
