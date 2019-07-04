import facade.FacadeFactory;
import org.junit.jupiter.api.Test;
import pokemons.Pokedex;

public class AAALoadAssets {
    /**
     * Loads up Pokedex and Movedex for future use.
     */
    @Test
    public void loadPokemonAndMoves() {
        FacadeFactory.createTestingEnvironment();
        Pokedex.getPokemon("Charmander");
    }
}
