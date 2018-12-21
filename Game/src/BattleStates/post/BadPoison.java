package BattleStates.post;

import BattleField.IBattleLogger;
import BattleStates.BattleState;
import Facade.FacadeFactory;
import Pokemons.Pokemon;

import java.util.List;

public class BadPoison extends BattleState{
    int turnCount;
    private BadPoison(){
        turnCount = 0;
    }
    public void execute(Pokemon pokemon){
        //lose (1/8 * turnCount)th of health
        turnCount++;
        pokemon.loseHP(pokemon.getBaseHP()/8 * turnCount);
        FacadeFactory.getInstance(IBattleLogger.class).println(pokemon.getName() + " is hurt by its poison!");
    }
    public static void tryToBadlyPoison(Pokemon pokemon){
        if (isBadlyPoisoned(pokemon)) {
            logger.println(pokemon.getName() + " is already Poisoned!");
        } else if (isNonVolatile(pokemon)) {
            logger.println("But it failed!");
        }
        else {
            pokemon.addPostBattleState(new BadPoison());
            FacadeFactory.getInstance(IBattleLogger.class).println(pokemon.getName() + " was badly poisoned!");
        }
    }
    public static boolean isBadlyPoisoned(Pokemon pokemon){
        return new BadPoison().containsState(pokemon);
    }
}