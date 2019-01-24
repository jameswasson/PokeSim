package Junit;

import org.junit.Test;

public class WrapperPokemon extends Move {
    @Test
    public void testWrap() {
        pokemons.WrapperPokemon wrapperPokemon = new pokemons.WrapperPokemon();
        pokemons.WrapperPokemon.wrap(Caterpie, wrapperPokemon);
        assert (Caterpie.getWrappedPokemon().getWrappedPokemon() != null);
    }

    @Test
    public void testRemoveWrap() {
        pokemons.WrapperPokemon wrapperPokemon = new pokemons.WrapperPokemon();
        pokemons.WrapperPokemon.wrap(Caterpie, wrapperPokemon);
        assert (Caterpie.getWrappedPokemon().getWrappedPokemon() != null);
        wrapperPokemon.removeSelf();
        assert (Caterpie.getWrappedPokemon().getWrappedPokemon() == null);
    }
}
