package AttackStates.Wrapper;

import AttackStates.AttackState;
import AttackStates.AttackWrapper;
import Pokemons.Pokemon;
import Utils.RNG;

public class ParalyzedAttack extends AttackWrapper {

    public ParalyzedAttack(AttackState state){
        nextAttack = state;
    }

    @Override
    public void execute(Pokemon ourSelves, Pokemon opponent) {
        if (RNG.random() > .25){
            nextAttack.execute(ourSelves,opponent);
        }
        else{
            logger.println(ourSelves.getName() + " is paralyzed! It can't move!");
        }
    }
}
