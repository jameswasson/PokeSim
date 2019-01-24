package AttackStates.Moves;

import AttackStates.Move;
import Pokemons.Pokemon;

public class Agility extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        ourselves.changeSPD(2);
    }
}
