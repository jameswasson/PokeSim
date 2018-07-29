package BattleStates.post;

import BattleField.BattleLog;
import BattleStates.BattleState;
import BattleStates.pre.Asleep;
import Pokemons.Pokemon;

public class Burn extends BattleState {
    public Burn(Pokemon pokemon){
        pokemon.addPostBattleState(this);
    }
    public boolean execute(Pokemon pokemon){
        logger.println("Burn not implemented");
        return true;
    }
    public static boolean isBurned(Pokemon pokemon){
        return false;//todo implememnt
    }
}
