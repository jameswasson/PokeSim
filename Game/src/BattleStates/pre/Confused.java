package BattleStates.pre;

import AttackStates.Wrapper.ConfusedAttack;
import BattleField.IBattleLogger;
import BattleStates.BattleState;
import Facade.FacadeFactory;
import Pokemons.Pokemon;
import Utils.RNG;

public class Confused extends BattleState {
    private int turnsTillNotConfused;
    private Confused(){
        turnsTillNotConfused = RNG.randomInt(1, 3);
    }
    public boolean execute(Pokemon pokemon){
        boolean shouldSnapOut = turnsTillNotConfused == 0;
        pokemon.setAttackState(new ConfusedAttack(pokemon.getAttackState(),shouldSnapOut));
        turnsTillNotConfused--;
        return shouldSnapOut;
    }
    public static boolean isConfused(Pokemon pokemon){
        return ConfusedAttack.isConfused(pokemon);
    }
    public static void tryToConfuse(Pokemon pokemon){
        if (isConfused(pokemon)){
            FacadeFactory.getInstance(IBattleLogger.class).println(pokemon.getName() + " is already confused!");
        }
        else{
            logger.println(pokemon.getName() + " is confused!");
            Confused confused = new Confused();
            pokemon.getPreBattleStates().add(confused);
            confused.execute(pokemon);
        }
    }
}
