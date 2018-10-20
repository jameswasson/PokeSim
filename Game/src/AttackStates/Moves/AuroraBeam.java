package AttackStates.Moves;

import AttackStates.Move;
import Pokemons.Pokemon;
import Utils.RNG;

public class AuroraBeam extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        super.attack(ourselves, opponent, damage);
        if (RNG.random() < .33)
            opponent.changeATK(-1);
    }
}
