package BattleStates.post;

import BattleStates.BattleState;
import BattleStates.pre.Asleep;
import Pokemons.Pokemon;

public class Drowsy extends BattleState {
    int turnsTillFallsAsleep;
    public Drowsy(Pokemon pokemon){
        pokemon.addPostBattleState(this);
        turnsTillFallsAsleep = 2;
    }
    public boolean execute(Pokemon pokemon){
        turnsTillFallsAsleep--;
        boolean shouldFallAsleep = turnsTillFallsAsleep == 0;
        if (shouldFallAsleep) {
            new Asleep(pokemon);
        }
        return shouldFallAsleep;
    }
}
