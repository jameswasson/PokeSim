package Junit;

import org.junit.Test;

public class WrapperPokemon extends Move {
    @Test
    public void testWrap(){
        Pokemons.WrapperPokemon wrapperPokemon = new Pokemons.WrapperPokemon();
        Pokemons.WrapperPokemon.wrap(Caterpie, wrapperPokemon);
        assert(Caterpie.getWrappedPokemon().getWrappedPokemon() != null);
    }
    @Test
    public void testRemoveWrap(){
        Pokemons.WrapperPokemon wrapperPokemon = new Pokemons.WrapperPokemon();
        Pokemons.WrapperPokemon.wrap(Caterpie, wrapperPokemon);
        assert(Caterpie.getWrappedPokemon().getWrappedPokemon() != null);
        wrapperPokemon.removeSelf();
        assert(Caterpie.getWrappedPokemon().getWrappedPokemon() == null);
    }
}
