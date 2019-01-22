package AttackStates.Wrapper;

import AttackStates.AttackState;
import AttackStates.AttackWrapper;
import Pokemons.Pokemon;

public class FrozenAttack extends AttackWrapper {
    public FrozenAttack(AttackState attackState){
        nextAttack = attackState;
    }

    @Override
    public void execute(Pokemon ourSelves, Pokemon opponent) {
        logger.println(ourSelves.getName() + " is frozen and is unable to move!");
    }
}
