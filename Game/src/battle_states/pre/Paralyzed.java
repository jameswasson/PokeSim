package battle_states.pre;

import attack_states.wrapper.ParalyzedAttack;
import battle_states.BattleState;
import pokemons.Pokemon;

public class Paralyzed extends BattleState {
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

    @Override
    public void execute(Pokemon pokemon) {
        pokemon.setAttackState(new ParalyzedAttack(pokemon.getAttackState()));
    }
}
