package AttackStates.Moves;

import AttackStates.Move;
import Pokemons.Pokemon;

public class JumpKick extends Move {
    @Override
    public void onMiss(Pokemon ourselves, Pokemon opponent) {
        super.onMiss(ourselves, opponent);
        ourselves.loseHP(ourselves.getBaseHP() / 2);
        logger.println(ourselves.getName() + " is hit with recoil!");
    }
}
