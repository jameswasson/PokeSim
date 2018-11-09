package AttackStates.Moves;

import AttackStates.Move;
import BattleStates.pre.Paralyzed;
import Pokemons.Pokemon;

public class Glare extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        Paralyzed.tryToParalyze(opponent);
    }
}
