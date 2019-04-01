package pokemons;


import attack_states.Move;
import attack_states.moves.FireBlast;
import attack_states.moves.FirePunch;
import attack_states.moves.Flamethrower;

public class FrozenPokemon extends WrapperPokemon {

    @Override
    public void loseHP(int HPLoss, Move move) {
        boolean canBurn = move instanceof FireBlast ||
                move instanceof FirePunch ||
                move instanceof Flamethrower;
        if (canBurn) {
            removeFreeze(getHead());
        }
        super.loseHP(HPLoss);
    }

    @Override
    public void attack(Pokemon toAttack) {
        logger.println(getHead().getName() + " is frozen and is unable to move!");
    }

    public static void tryToFreeze(Pokemon pokemon) {
        if (!isFrozen(pokemon)) {
            logger.println(pokemon.getName() + " is frozen!");
            WrapperPokemon.wrap(pokemon, new FrozenPokemon());
        } else {
            logger.println(pokemon.getName() + " is already frozen!");
        }
    }

    public static boolean isFrozen(Pokemon pokemon) {
        return WrapperPokemon.containsWrapped(pokemon, FrozenPokemon.class);
    }

    public static void removeFreeze(Pokemon pokemon) {
        WrapperPokemon wrapper = WrapperPokemon.getWrapped(pokemon, FrozenPokemon.class);
        if (wrapper != null)
            wrapper.removeSelf();
    }
}
