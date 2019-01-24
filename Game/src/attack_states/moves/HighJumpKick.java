package attack_states.moves;

import attack_states.Move;
import pokemons.Pokemon;

public class HighJumpKick extends Move {
    @Override
    public void onMiss(Pokemon ourselves) {
        new JumpKick().onMiss(ourselves);
    }
}
