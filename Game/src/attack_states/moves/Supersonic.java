package AttackStates.Moves;

import AttackStates.Move;
import BattleStates.pre.Confused;
import Pokemons.Pokemon;

public class Supersonic extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        Confused.tryToConfuse(opponent);
    }
}
