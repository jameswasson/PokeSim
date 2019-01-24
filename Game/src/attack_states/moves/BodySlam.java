package AttackStates.Moves;

import AttackStates.Move;
import BattleStates.pre.Paralyzed;
import Pokemons.Pokemon;
import Utils.RNG;

public class BodySlam extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        super.attack(ourselves, opponent, damage);
        if (RNG.random() < .3)
            Paralyzed.tryToParalyze(opponent);
    }
}
