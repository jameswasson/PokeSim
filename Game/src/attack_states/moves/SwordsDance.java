package AttackStates.Moves;

import AttackStates.Move;
import Pokemons.Pokemon;

public class SwordsDance extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        ourselves.changeATK(2);
    }
}
