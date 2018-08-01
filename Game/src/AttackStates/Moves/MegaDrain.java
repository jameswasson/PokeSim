package AttackStates.Moves;

import AttackStates.Move;
import Pokemons.Pokemon;

public class MegaDrain extends Move {
    public void attack(Pokemon ourSelf,Pokemon opponent){
        logger.println("Drained " + "X" + " HP from " + opponent.getName());
        logger.println(ourSelf.getName() +" gained " + "X" + " HP!");
    }
}
