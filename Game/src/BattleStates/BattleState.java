package BattleStates;

import BattleField.IBattleLogger;
import BattleStates.post.BadPoison;
import BattleStates.post.Burn;
import BattleStates.post.Poison;
import BattleStates.pre.Asleep;
import BattleStates.pre.Paralyzed;
import Facade.FacadeFactory;
import Pokemons.Pokemon;

import java.util.List;

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
        return Burn.isBurned(pokemon) || Paralyzed.isParalyzed(pokemon) ||
                Poison.isPoisoned(pokemon) || BadPoison.isBadlyPoisoned(pokemon) ||
                Asleep.isAsleep(pokemon);
    }

    abstract public void execute(Pokemon pokemon);

    public void removeState(Pokemon pokemon) {
        removeFromStates(pokemon, pokemon.getPreBattleStates());
        removeFromStates(pokemon, pokemon.getPostBattleStates());
    }

    private void removeFromStates(Pokemon pokemon, List<BattleState> list) {
        BattleState state = null;
        for (BattleState bs : list) {
            if (this.getClass().isInstance(bs)) {
                state = bs;
                break;
            }
        }
        if (state != null)
            list.remove(state);
    }

    public boolean containsState(Pokemon pokemon) {
        for (BattleState bs : pokemon.getPreBattleStates()) {
            if (this.getClass().isInstance(bs))
                return true;
        }
        return false;
    }
}
