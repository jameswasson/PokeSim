package attack_states.moves;

import attack_states.Move;
import pokemons.Pokemon;

public class JumpKick extends Move {
    @Override
    public void onMiss(Pokemon ourselves) {
        super.onMiss(ourselves);
        ourselves.loseHP(ourselves.getBaseHP() / 2);
        logger.println(ourselves.getName() + " is hit with recoil!");
    }
}
