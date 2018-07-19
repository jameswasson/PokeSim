package BattleStates.pre;

import AttackStates.Wrapper.AsleepAttack;
import AttackStates.AttackState;
import BattleStates.BattleState;
import Pokemons.Pokemon;
import Utils.RNG;

public class Asleep extends BattleState {
    public int turnsAsleep;
    public Asleep(Pokemon pokemon){
        logger.println(pokemon.getName() + " fell asleep!");
        pokemon.getPreBattleStates().add(this);
        turnsAsleep = (int)(RNG.random()*3) + 1;
    }
    public boolean execute(Pokemon pokemon){
        AttackState nextAttack = pokemon.getAttackState();
        boolean shouldWakeUp = turnsAsleep == 0;
        AttackState wrappedAttack = new AsleepAttack(nextAttack,shouldWakeUp);
        pokemon.setAttackState(wrappedAttack);
        turnsAsleep--;
        return shouldWakeUp;
    }
}