package BattleStates;

import BattleField.IBattleLogger;
import BattleStates.post.BadPoison;
import BattleStates.post.Burn;
import BattleStates.post.Poison;
import BattleStates.pre.Asleep;
import BattleStates.pre.Paralyzed;
import Facade.FacadeFactory;
import Pokemons.Pokemon;

public class BattleState {

    protected static IBattleLogger logger = FacadeFactory.getInstance(IBattleLogger.class);

    public void execute(Pokemon pokemon){
        System.out.println("Function not implemented.");
    }
    public static boolean isNonVolatile(Pokemon pokemon){
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

    public void removeState(Pokemon pokemon){
        BattleState state = null;
        for (BattleState bs : pokemon.getPreBattleStates()){
            if (this.getClass().isInstance(bs)){
                state = bs;
                break;
            }
        }
        pokemon.getPreBattleStates().remove(state);
    }
    public boolean containsState(Pokemon pokemon){
        for (BattleState bs: pokemon.getPreBattleStates()){
            if (this.getClass().isInstance(bs))
                return true;
        }
        return false;
    }
}
