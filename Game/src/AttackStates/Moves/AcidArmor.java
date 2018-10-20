package AttackStates.Moves;

import AttackStates.Move;
import Pokemons.Pokemon;

public class AcidArmor extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        ourselves.changeDEF(2);
    }
}
