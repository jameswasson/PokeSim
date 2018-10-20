package AttackStates.Moves;

import AttackStates.Move;
import Pokemons.Pokemon;

public class Smokescreen extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        opponent.changeACC(-1);
    }
}
