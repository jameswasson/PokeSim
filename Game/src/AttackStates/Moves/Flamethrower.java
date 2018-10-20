package AttackStates.Moves;

import AttackStates.Move;
import BattleStates.post.Burn;
import Pokemons.Pokemon;
import Utils.RNG;

public class Flamethrower extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        super.attack(ourselves, opponent, damage);
        if (RNG.random() < .1)
            Burn.tryToBurn(opponent);
    }
}
