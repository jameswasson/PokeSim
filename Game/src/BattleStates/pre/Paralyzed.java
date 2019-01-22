package BattleStates.pre;

import AttackStates.Wrapper.ParalyzedAttack;
import BattleStates.BattleState;
import Pokemons.Pokemon;

public class Paralyzed extends BattleState {
    @Override
    public void execute(Pokemon pokemon) {
        pokemon.setAttackState(new ParalyzedAttack(pokemon.getAttackState()));
    }

    public static void tryToParalyze(Pokemon pokemon) {
        if (isParalyzed(pokemon)) {
            logger.println(pokemon.getName() + " is already paralyzed!");
        } else if (isNonVolatile(pokemon)) {
            logger.println("But it failed!");
        } else {
            logger.println(pokemon.getName() + " is paralyzed! It can't move!");
            BattleState paralyzed = new Paralyzed();
            pokemon.getPreBattleStates().add(paralyzed);
        }
    }

    public static boolean isParalyzed(Pokemon pokemon) {
        return new Paralyzed().containsState(pokemon);
    }
}
