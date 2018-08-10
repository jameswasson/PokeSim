package AttackStates.Moves;

import AttackStates.Move;
import Pokemons.Pokemon;

public class HornDrill extends Move {
    @Override
    protected double getAccuracy(Pokemon ourselves, Pokemon opponent) {
        return new Guillotine().getAccuracy(ourselves,opponent);
    }
}
