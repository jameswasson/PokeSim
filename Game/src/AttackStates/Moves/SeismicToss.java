package AttackStates.Moves;

import AttackStates.Move;
import Pokemons.Pokemon;

public class SeismicToss extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        new NightShade().attack(ourselves,opponent,damage);
    }
    //todo
}
