package pokemons;

public class FlinchedPokemon extends WrapperPokemon {
    @Override
    public void attack(Pokemon toAttack) {
        logger.println(getName() + " flinched!");
        removeSelf();
    }

    @Override
    public void runPostBattleStates() {
        removeSelf();
        super.runPostBattleStates();
    }

    public static boolean isFlinched(Pokemon pokemon) {
        return WrapperPokemon.containsWrapped(pokemon, FlinchedPokemon.class);
    }

    public static void makeFlinch(Pokemon pokemon) {
        if (!isFlinched(pokemon)) {
            WrapperPokemon.wrap(pokemon, new FlinchedPokemon());
        }
    }
}
