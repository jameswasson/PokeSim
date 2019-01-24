package AttackStates.Moves;

import AttackStates.Move;
import Pokemons.Pokemon;

public class HighJumpKick extends Move {
    @Override
    public void onMiss(Pokemon ourselves, Pokemon opponent) {
        new JumpKick().onMiss(ourselves, opponent);
    }
}
