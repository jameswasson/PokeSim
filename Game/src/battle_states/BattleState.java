package battle_states;

import battle_field.IBattleLogger;
import battle_states.post.BadPoison;
import battle_states.post.Burn;
import battle_states.post.Poison;
import facade.FacadeFactory;
import pokemons.Pokemon;
import pokemons.pokemon_states.ParalyzedPokemon;
import pokemons.pokemon_states.SleepingPokemon;

public abstract class BattleState {

    protected static IBattleLogger logger = FacadeFactory.getInstance(IBattleLogger.class);

    public static boolean isNonVolatile(Pokemon pokemon) {
        /*returns true if Pokemon is any of the following:
            burned
            frozen
            paralyzed
            poisoned
            badly poisoned
            asleep*/
        //todo add check for frozen
        return Burn.isBurned(pokemon) || ParalyzedPokemon.isParalyzed(pokemon) ||
                Poison.isPoisoned(pokemon) || BadPoison.isBadlyPoisoned(pokemon) ||
                SleepingPokemon.isAsleep(pokemon);
    }

    public abstract void execute(Pokemon pokemon);

    public boolean containsState(Pokemon pokemon) {
        for (BattleState bs : pokemon.getPostBattleStates()) {
            if (this.getClass().isInstance(bs))
                return true;
        }
        return false;
    }
}
