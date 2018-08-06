package AttackStates.Moves;

import AttackStates.Move;
import Pokemons.Pokemon;

public class Fissure extends Move {
    @Override
    protected int getAccuracy(Pokemon ourselves, Pokemon opponent) {
        return new Guillotine().getAccuracy(ourselves,opponent);
    }
}
