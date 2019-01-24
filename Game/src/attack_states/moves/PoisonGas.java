package AttackStates.Moves;

import AttackStates.Move;
import BattleStates.post.Poison;
import Pokemons.Pokemon;

public class PoisonGas extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        Poison.tryToPoison(opponent);
    }
}
