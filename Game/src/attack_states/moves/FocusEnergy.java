package attack_states.moves;

import attack_states.Move;
import pokemons.Pokemon;

public class FocusEnergy extends Move {
    //Multiply by 4, Pokemon Stadium does some weird things but this will do fine.
    //If I'm right, Focus Energy used by any pokemon at lvl 100 guarantees a crit.
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        ourselves.setCritBonus(4);
        logger.println(ourselves.getName() + " is getting pumped!");
    }
}
