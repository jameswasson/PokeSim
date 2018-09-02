package AttackStates.Moves;

import AttackStates.Move;
import BattleStates.post.Burn;
import Pokemons.Pokemon;
import Utils.RNG;

public class FirePunch extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        super.attack(ourselves, opponent, damage);
        if (RNG.random() < 0.1)
            Burn.tryToBurn(opponent);
    }
}