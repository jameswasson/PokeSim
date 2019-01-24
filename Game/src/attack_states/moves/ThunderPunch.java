package AttackStates.Moves;

import AttackStates.Move;
import BattleStates.pre.Paralyzed;
import Pokemons.EleType;
import Pokemons.Pokemon;

public class ThunderPunch extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        super.attack(ourselves, opponent, damage);
        if (opponent.getType1() != EleType.Electric && opponent.getType2() != EleType.Electric) {
            Paralyzed.tryToParalyze(opponent);
        }
    }
}
