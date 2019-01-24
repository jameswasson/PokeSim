package BattleStates.pre;

import BattleStates.BattleState;
import Pokemons.Pokemon;

public class Flying extends BattleState {
    public static boolean isFlying(Pokemon pokemon) {
        return new Flying().containsState(pokemon);
    }

    public void execute(Pokemon pokemon) {

    }
}
