import org.junit.jupiter.api.Test;
import pokemons.Pokedex;
import pokemons.Pokemon;
import pokemons.WrapperPokemon;
import pokemons.pokemon_states.FlinchedPokemon;

public class WrapperPokemonTest extends MoveTest {
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
        assert (p.containsState(FlinchedPokemon.class));
    }
}
