package AttackStates.Wrapper;

import AttackStates.AttackState;
import AttackStates.AttackWrapper;
import Pokemons.Pokemon;

public class FlinchedAttack extends AttackWrapper {
    public FlinchedAttack(AttackState attack) {
        nextAttack = attack;
    }

    @Override
    public void execute(Pokemon ourSelves, Pokemon opponent) {
        logger.println(ourSelves.getName() + " flinched!");
    }

    public static boolean isFlinched(Pokemon pokemon) {
        AttackState state = pokemon.getAttackState();
        return state instanceof FlinchedAttack;
    }

    public static void makeFlinch(Pokemon pokemon) {
        if (!isFlinched(pokemon)) {
            FlinchedAttack wrapper = new FlinchedAttack(pokemon.getAttackState());
            pokemon.setAttackState(wrapper);
        }
    }
}
