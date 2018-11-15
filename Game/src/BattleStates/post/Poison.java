package BattleStates.post;

import BattleField.IBattleLogger;
import BattleStates.BattleState;
import Facade.FacadeFactory;
import Pokemons.Pokemon;

import java.util.List;

public class Poison extends BattleState{
    public boolean execute(Pokemon pokemon){
        //lose 1/8th of health
        pokemon.loseHP(pokemon.getBaseHP()/8);
        FacadeFactory.getInstance(IBattleLogger.class).println(pokemon.getName() + " is hurt by its poison!");
        return false;
    }
    public static void tryToPoison(Pokemon pokemon){
        if (!isPoisoned(pokemon)) {
            pokemon.addPostBattleState(new Poison());
            FacadeFactory.getInstance(IBattleLogger.class).println(pokemon.getName() + " was poisoned!");
        }
    }
    public static boolean isPoisoned(Pokemon pokemon){
        List<BattleState> postStates =  pokemon.getPostBattleStates();
        for (BattleState state: postStates)
            if (state.getClass() == Poison.class)
                return true;
        return false;
    }
}
