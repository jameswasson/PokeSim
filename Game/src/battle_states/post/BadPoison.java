package battle_states.post;

import battle_states.BattleState;
import pokemons.Pokemon;

public class BadPoison extends BattleState {
    int turnCount;

    private BadPoison() {
        turnCount = 0;
    }

    public static void tryToBadlyPoison(Pokemon pokemon) {
        if (isBadlyPoisoned(pokemon)) {
            logger.println(pokemon.getName() + " is already Poisoned!");
        } else if (isNonVolatile(pokemon)) {
            logger.println("But it failed!");
        } else {
            pokemon.addPostBattleState(new BadPoison());
            logger.println(pokemon.getName() + " was badly poisoned!");
        }
    }

    public static boolean isBadlyPoisoned(Pokemon pokemon) {
        return new BadPoison().containsState(pokemon);
    }

    public void execute(Pokemon pokemon) {
        //lose (1/8 * turnCount)th of health
        turnCount++;
        pokemon.loseHP(pokemon.getBaseHP() / 8 * turnCount);
        logger.println(pokemon.getName() + " is hurt by its poison!");
    }
}