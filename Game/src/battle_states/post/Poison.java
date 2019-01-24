package battle_states.post;

import battle_states.BattleState;
import pokemons.Pokemon;

public class Poison extends BattleState {
    public static void tryToPoison(Pokemon pokemon) {
        if (isPoisoned(pokemon)) {
            logger.println(pokemon.getName() + " is already Poisoned!");
        } else if (isNonVolatile(pokemon)) {
            logger.println("But it failed!");
        } else {
            pokemon.addPostBattleState(new Poison());
            logger.println(pokemon.getName() + " was poisoned!");
        }
    }

    public static boolean isPoisoned(Pokemon pokemon) {
        return new Poison().containsState(pokemon);
    }

    public void execute(Pokemon pokemon) {
        //lose 1/8th of health
        pokemon.loseHP(pokemon.getBaseHP() / 8);
        logger.println(pokemon.getName() + " is hurt by its poison!");
    }
}
