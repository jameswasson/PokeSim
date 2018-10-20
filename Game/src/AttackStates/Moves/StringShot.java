package AttackStates.Moves;

import AttackStates.Move;
import Pokemons.Pokemon;

public class StringShot extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        opponent.changeSPD(-1);
    }
}
