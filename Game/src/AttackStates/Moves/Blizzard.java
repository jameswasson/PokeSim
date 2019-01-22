package AttackStates.Moves;

import AttackStates.Move;
import BattleStates.pre.Frozen;
import Pokemons.Pokemon;
import Utils.RNG;

public class Blizzard extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        super.attack(ourselves, opponent, damage);
        if (RNG.random() < .1)
            Frozen.tryToFreeze(opponent);
    }
}
