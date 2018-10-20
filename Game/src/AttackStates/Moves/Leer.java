package AttackStates.Moves;

import AttackStates.Move;
import Pokemons.Pokemon;

public class Leer extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        opponent.changeDEF(-1);
    }
}
