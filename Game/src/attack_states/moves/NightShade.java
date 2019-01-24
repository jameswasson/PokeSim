package AttackStates.Moves;

import AttackStates.Move;
import Pokemons.Pokemon;

public class NightShade extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        super.attack(ourselves, opponent, opponent.getLevel());
    }
    //todo
}
