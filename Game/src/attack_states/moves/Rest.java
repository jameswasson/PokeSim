package attack_states.moves;

import attack_states.Move;
import pokemons.Pokemon;
import pokemons.SleepingPokemon;

public class Rest extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        SleepingPokemon.tryToPutToSleep(ourselves, 2);
        ourselves.gainHP(ourselves.getBaseHP() - ourselves.getCurHP());
        logger.println(ourselves.getName() + " regained health!");
    }
}
