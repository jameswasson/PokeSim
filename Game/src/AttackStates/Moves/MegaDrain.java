package AttackStates.Moves;

import AttackStates.AttackState;
import Pokemons.Pokemon;

public class MegaDrain extends AttackState {
    public void execute(Pokemon ourSelf,Pokemon opponent){
        sayWeUsedMove(ourSelf);
        logger.println("Drained " + "X" + " HP from " + opponent.getName());
        logger.println(ourSelf.getName() +" gained " + "X" + " HP!");
    }
}
