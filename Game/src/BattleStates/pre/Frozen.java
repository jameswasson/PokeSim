package BattleStates.pre;

import AttackStates.AttackState;
import AttackStates.Wrapper.FrozenAttack;
import BattleStates.BattleState;
import Pokemons.FrozenPokemon;
import Pokemons.Pokemon;
import Pokemons.WrapperPokemon;

public class Frozen extends BattleState {

    @Override
    public void execute(Pokemon pokemon) {
        AttackState nextAttack = pokemon.getAttackState();
        pokemon.setAttackState(new FrozenAttack(nextAttack));
    }

    public static void tryToFreeze(Pokemon pokemon){
        if (!isFrozen(pokemon)){
            logger.println(pokemon.getName() + " is frozen!");
            BattleState battleState = new Frozen();
            pokemon.getPreBattleStates().add(battleState);
            WrapperPokemon.wrap(pokemon, new FrozenPokemon());
        }
        else{
            logger.println(pokemon.getName() + " is already frozen!");
        }
    }

    public static boolean isFrozen(Pokemon pokemon){
        return new Frozen().containsState(pokemon);
    }

    public static void removeFreeze(Pokemon pokemon)
    {
        new Frozen().removeState(pokemon);
    }

}
