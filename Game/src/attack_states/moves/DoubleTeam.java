package AttackStates.Moves;

import AttackStates.Move;
import Pokemons.Pokemon;

public class DoubleTeam extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        ourselves.changeEVA(1);
    }
}
