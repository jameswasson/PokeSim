package attack_states.moves;

import attack_states.Move;
import pokemons.Pokemon;

public class Recover extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        int toRecover = Math.max(1, ourselves.getBaseHP() / 2);
        ourselves.gainHP(toRecover);
        logger.println(ourselves.getName() + " regained health!");
    }
}
