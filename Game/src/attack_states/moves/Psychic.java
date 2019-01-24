package AttackStates.Moves;

import AttackStates.Move;
import Pokemons.Pokemon;
import Utils.RNG;

public class Psychic extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        super.attack(ourselves, opponent, damage);
        if (RNG.random() < .332)
            opponent.changeSPC(-1);
    }
}
