package pokemons;

public class FlinchedPokemon extends WrapperPokemon {
    @Override
    public void attack(Pokemon toAttack) {
        logger.println(getName() + " flinched!");
        removeSelf();
    }
}
