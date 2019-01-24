package battle_states;


import battle_states.pre.Digging;
import battle_states.pre.Flying;
import pokemons.Pokemon;

public class SemiInvulnerable {
    public static boolean isSemiInvulnerable(Pokemon pokemon) {
        return Digging.isDigging(pokemon) || Flying.isFlying(pokemon);
    }
}
