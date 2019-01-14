package BattleStates;

import BattleStates.pre.Digging;
import BattleStates.pre.Flying;
import Pokemons.Pokemon;

public class SemiInvulnerable {
    public static boolean isSemiInvulnerable(Pokemon pokemon) {
        return Digging.isDigging(pokemon) || Flying.isFlying(pokemon);
    }
}
