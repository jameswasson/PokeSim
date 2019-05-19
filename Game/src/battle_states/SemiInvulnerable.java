package battle_states;

import attack_states.moves.Fly;
import pokemons.Pokemon;

public class SemiInvulnerable {
    public static boolean isSemiInvulnerable(Pokemon pokemon) {
        return Fly.isFlying(pokemon);
    }
}
