package BattleStates;

import BattleField.IBattleLogger;
import Facade.FacadeFactory;
import Pokemons.Pokemon;

public class BattleState {

    protected IBattleLogger logger = FacadeFactory.getInstance(IBattleLogger.class);

    /**
     * @return a boolean that says if the state should be removed or not.
     * */
    public boolean execute(Pokemon pokemon){
        System.out.println("Function not implemented.");
        boolean shouldRemove = false;
        return shouldRemove;
    }
}
