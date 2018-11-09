package AttackStates.Moves;

import AttackStates.Move;
import BattleStates.pre.Paralyzed;
import Pokemons.EleType;
import Pokemons.Pokemon;

public class ThunderWave extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        super.attack(ourselves, opponent, damage);
        if (opponent.getType1() != EleType.Ground && opponent.getType2() != EleType.Ground){
            Paralyzed.tryToParalyze(opponent);
        }
    }
}
