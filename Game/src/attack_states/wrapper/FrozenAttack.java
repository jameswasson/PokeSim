package attack_states.wrapper;

import attack_states.AttackState;
import attack_states.AttackWrapper;
import pokemons.Pokemon;

public class FrozenAttack extends AttackWrapper {
    public FrozenAttack(AttackState attackState) {
        nextAttack = attackState;
    }

    @Override
    public void execute(Pokemon ourSelves, Pokemon opponent) {
        logger.println(ourSelves.getName() + " is frozen and is unable to move!");
    }
}
