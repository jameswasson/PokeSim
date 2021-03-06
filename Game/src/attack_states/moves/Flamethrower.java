package attack_states.moves;

import attack_states.Move;
import battle_states.post.Burn;
import pokemons.Pokemon;
import utils.RNG;

public class Flamethrower extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        super.attack(ourselves, opponent, damage);
        if (RNG.random() < .1)
            Burn.tryToBurn(opponent);
    }
}
