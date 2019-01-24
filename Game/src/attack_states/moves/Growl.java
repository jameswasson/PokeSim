package AttackStates.Moves;

import AttackStates.Move;
import Pokemons.Pokemon;

public class Growl extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        opponent.changeATK(-1);
    }
}
