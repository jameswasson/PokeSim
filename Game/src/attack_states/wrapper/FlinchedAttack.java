package attack_states.wrapper;


import attack_states.AttackState;
import attack_states.AttackWrapper;
import pokemons.Pokemon;

public class FlinchedAttack extends AttackWrapper {
    private FlinchedAttack(AttackState attack) {
        nextAttack = attack;
    }

    private static boolean isFlinched(Pokemon pokemon) {
        AttackState state = pokemon.getAttackState();
        return state instanceof FlinchedAttack;
    }

    public static void makeFlinch(Pokemon pokemon) {
        if (!isFlinched(pokemon)) {
            FlinchedAttack wrapper = new FlinchedAttack(pokemon.getAttackState());
            pokemon.setAttackState(wrapper);
        }
    }

    @Override
    public void execute(Pokemon ourSelves, Pokemon opponent) {
        logger.println(ourSelves.getName() + " flinched!");
    }
}
