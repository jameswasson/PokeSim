package BattleStates.pre;

import BattleStates.BattleState;
import Pokemons.Pokemon;

public class Digging extends BattleState {
    public static boolean isDigging(Pokemon pokemon) {
        return new Digging().containsState(pokemon);
    }
}
