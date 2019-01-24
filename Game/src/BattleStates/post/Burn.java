package BattleStates.post;

import BattleStates.BattleState;
import Pokemons.Pokemon;

public class Burn extends BattleState {
    public static void tryToBurn(Pokemon pokemon) {
        if (isBurned(pokemon)) {
            logger.println(pokemon.getName() + " is already Burned!");
        } else if (isNonVolatile(pokemon)) {
            logger.println("But it failed!");
        } else {
            pokemon.addPostBattleState(new Burn());
            logger.println(pokemon.getName() + " was burned!");
        }
    }

    public static boolean isBurned(Pokemon pokemon) {
        return new Burn().containsState(pokemon);
    }

    public void execute(Pokemon pokemon) {
        //lose 1/8th of health
        pokemon.loseHP(pokemon.getBaseHP() / 8);
        logger.println(pokemon.getName() + " is hurt by its burn!");
    }
}