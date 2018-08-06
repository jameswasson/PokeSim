package AttackStates.Moves;

import AttackStates.Move;
import Pokemons.Pokemon;

public class Guillotine extends Move {
    @Override
    protected int getAccuracy(Pokemon ourselves, Pokemon opponent) {
        if (ourselves.getLevel() < opponent.getLevel() || ourselves.getCurSPD() < opponent.getCurSPD())
            return 0;
        else
            return ourselves.getLevel() - opponent.getLevel() + 30;
    }
}
