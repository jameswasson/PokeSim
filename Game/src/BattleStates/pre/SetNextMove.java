package BattleStates.pre;

import AttackStates.AttackState;
import BattleStates.BattleState;
import Pokemons.Pokemon;

public class SetNextMove extends BattleState {
    AttackState nextMove;
    public SetNextMove(AttackState attackState){
        nextMove = attackState;
    }
    public boolean execute(Pokemon pokemon){
        pokemon.setAttackState(nextMove);
        return true;
    }
}