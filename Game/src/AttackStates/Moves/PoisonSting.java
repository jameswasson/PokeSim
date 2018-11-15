package AttackStates.Moves;

import AttackStates.Move;
import BattleStates.post.Poison;
import Pokemons.Pokemon;
import Utils.RNG;

public class PoisonSting extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        super.attack(ourselves, opponent, damage);
        if (RNG.random() < .20)
            Poison.tryToPoison(opponent);
    }
}
