package battle_states.pre;

import battle_states.BattleState;
import pokemons.Pokemon;

public class Digging extends BattleState {
    public static boolean isDigging(Pokemon pokemon) {
        return new Digging().containsState(pokemon);
    }

    public void execute(Pokemon pokemon) {

    }
}
