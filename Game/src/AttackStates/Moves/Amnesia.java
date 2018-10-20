package AttackStates.Moves;

import AttackStates.Move;
import Pokemons.Pokemon;

public class Amnesia extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        ourselves.changeSPC(2);
    }
}
