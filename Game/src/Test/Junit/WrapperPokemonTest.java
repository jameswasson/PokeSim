package Junit;

import org.junit.Test;
import pokemons.FlinchedPokemon;
import pokemons.Pokedex;
import pokemons.Pokemon;
import pokemons.WrapperPokemon;

public class WrapperPokemonTest extends Move {
    @Test
    public void testWrap() {
        WrapperPokemon wrapperPokemon = new WrapperPokemon();
        WrapperPokemon.wrap(Caterpie, wrapperPokemon);
        assert (Caterpie.getWrappedPokemon().getWrappedPokemon() != null);
    }

    @Test
    public void testRemoveWrap() {
        WrapperPokemon wrapperPokemon = new WrapperPokemon();
        WrapperPokemon.wrap(Caterpie, wrapperPokemon);
        assert (Caterpie.getWrappedPokemon().getWrappedPokemon() != null);
        wrapperPokemon.removeSelf();
        assert (Caterpie.getWrappedPokemon().getWrappedPokemon() == null);
    }

    @Test
    public void testContains() {
        Pokemon p = Pokedex.getPokemon("Caterpie");
        WrapperPokemon.wrap(p, new FlinchedPokemon());
        assert (WrapperPokemon.containsWrapped(p, FlinchedPokemon.class));
    }
}
