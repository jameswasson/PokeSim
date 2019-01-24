package attack_states.wrapper;


import attack_states.AttackState;
import attack_states.AttackWrapper;
import pokemons.Pokemon;
import utils.RNG;

public class ParalyzedAttack extends AttackWrapper {

    public ParalyzedAttack(AttackState state) {
        nextAttack = state;
    }

    @Override
    public void execute(Pokemon ourSelves, Pokemon opponent) {
        if (RNG.random() > .25) {
            nextAttack.execute(ourSelves, opponent);
        } else {
            logger.println(ourSelves.getName() + " is paralyzed! It can't move!");
        }
    }
}
