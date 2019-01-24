package AttackStates.Moves;

import AttackStates.Move;
import BattleStates.pre.Confused;
import Pokemons.Pokemon;

public class ConfuseRay extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        Confused.tryToConfuse(opponent);
    }
}
