package AttackStates.Moves;

import AttackStates.Move;
import Pokemons.Pokemon;

public class Screech extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        opponent.changeDEF(-2);
    }
}
