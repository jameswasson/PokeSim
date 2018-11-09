package BattleStates.pre;

import AttackStates.AttackState;
import AttackStates.Wrapper.ParalyzedAttack;
import BattleStates.BattleState;
import Pokemons.Pokemon;

public class Paralyzed extends BattleState {
    @Override
    public boolean execute(Pokemon pokemon) {
        pokemon.setAttackState(new ParalyzedAttack(pokemon.getAttackState()));
        return false;//paralysis never wears off
    }
    public static void tryToParalyze(Pokemon pokemon){
        if (!isParalyzed(pokemon)) {
            logger.println(pokemon.getName() + " is paralyzed! It can't move!");
            BattleState paralyzed = new Paralyzed();
            pokemon.getPreBattleStates().add(paralyzed);
            paralyzed.execute(pokemon);
        }
    }
    public static boolean isParalyzed(Pokemon pokemon){
        AttackState state = pokemon.getAttackState();
        return state instanceof ParalyzedAttack;
    }
}
