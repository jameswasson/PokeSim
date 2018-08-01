package BattleStates.pre;

import AttackStates.Wrapper.AsleepAttack;
import AttackStates.AttackState;
import BattleField.IBattleLogger;
import BattleStates.BattleState;
import Facade.FacadeFactory;
import Pokemons.Pokedex;
import Pokemons.Pokemon;
import Utils.RNG;

public class Asleep extends BattleState {
    public int turnsAsleep;
    public Asleep(){
        turnsAsleep = RNG.randomInt(1,3);
    }
    public boolean execute(Pokemon pokemon){
        AttackState nextAttack = pokemon.getAttackState();
        boolean shouldWakeUp = turnsAsleep == 0;
        AttackState wrappedAttack = new AsleepAttack(nextAttack,shouldWakeUp);
        pokemon.setAttackState(wrappedAttack);
        turnsAsleep--;
        return shouldWakeUp;
    }
    public static void tryToPutToSleep(Pokemon pokemon){
        if (Asleep.isAsleep(pokemon)){
            logger.println(pokemon.getName() + " is already asleep!");
        }
        else{
            logger.println(pokemon.getName() + " fell asleep!");
            pokemon.getPreBattleStates().add(new Asleep());
        }
    }
    public static boolean isAsleep(Pokemon pokemon){
        for (BattleState state:pokemon.getPreBattleStates()){
            if (state.getClass() == Asleep.class)
                return true;
        }
        return false;
    }
}