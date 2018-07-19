package AttackStates.Moves;


import AttackStates.AttackState;
import BattleStates.post.Drowsy;
import Pokemons.Pokemon;

public class Yawn extends AttackState {
    public void execute(Pokemon us, Pokemon them){
        sayWeUsedMove(us);
        new Drowsy(them);
    }
}
