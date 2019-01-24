package battle_states.pre;


import battle_states.BattleState;
import pokemons.Pokemon;

public class Flying extends BattleState {
    public static boolean isFlying(Pokemon pokemon) {
        return new Flying().containsState(pokemon);
    }

    public void execute(Pokemon pokemon) {

    }
}
