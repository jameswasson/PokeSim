package AttackStates.Moves;

import AttackStates.AttackState;
import BattleStates.pre.Confused;
import Pokemons.Pokemon;

public class ConfuseRay extends AttackState {

    public void execute(Pokemon us, Pokemon them){
        sayWeUsedMove(us);
        Confused.tryToConfuse(them);
    }
}
