package AttackStates.Moves;

import AttackStates.Move;
import BattleStates.pre.Confused;
import Pokemons.Pokemon;

public class ConfuseRay extends Move {
    public void attack(Pokemon us, Pokemon them){
        Confused.tryToConfuse(them);
    }
}
