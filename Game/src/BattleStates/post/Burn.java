package BattleStates.post;

import BattleField.BattleLog;
import BattleField.IBattleLogger;
import BattleStates.BattleState;
import BattleStates.pre.Asleep;
import Facade.FacadeFactory;
import Pokemons.Pokemon;

import java.util.List;

public class Burn extends BattleState {
    public boolean execute(Pokemon pokemon){
        //lose 1/8th of health
        pokemon.loseHP(pokemon.getBaseHP()/8);
        FacadeFactory.getInstance(IBattleLogger.class).println(pokemon.getName() + " is hurt by its burn!");
        return false;
    }
    public static void tryToBurn(Pokemon pokemon){
        if (!isBurned(pokemon)) {
            pokemon.addPostBattleState(new Burn());
            FacadeFactory.getInstance(IBattleLogger.class).println(pokemon.getName() + " was burned!");
        }
    }
    public static boolean isBurned(Pokemon pokemon){
        List<BattleState> postStates =  pokemon.getPostBattleStates();
        for (BattleState state: postStates)
            if (state.getClass() == Burn.class)
                return true;
        return false;
    }
}