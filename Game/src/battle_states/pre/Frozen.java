package battle_states.pre;


import attack_states.AttackState;
import attack_states.wrapper.FrozenAttack;
import battle_states.BattleState;
import pokemons.FrozenPokemon;
import pokemons.Pokemon;
import pokemons.WrapperPokemon;

public class Frozen extends BattleState {

    public static void tryToFreeze(Pokemon pokemon) {
        if (!isFrozen(pokemon)) {
            logger.println(pokemon.getName() + " is frozen!");
            BattleState battleState = new Frozen();
            pokemon.getPreBattleStates().add(battleState);
            WrapperPokemon.wrap(pokemon, new FrozenPokemon());
        } else {
            logger.println(pokemon.getName() + " is already frozen!");
        }
    }

    public static boolean isFrozen(Pokemon pokemon) {
        return new Frozen().containsState(pokemon);
    }

    public static void removeFreeze(Pokemon pokemon) {
        new Frozen().removeState(pokemon);
    }

    @Override
    public void execute(Pokemon pokemon) {
        AttackState nextAttack = pokemon.getAttackState();
        pokemon.setAttackState(new FrozenAttack(nextAttack));
    }

}