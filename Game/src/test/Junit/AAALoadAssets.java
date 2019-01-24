package Junit;

import org.junit.Test;
import pokemons.Pokedex;

/**
 * Titled AAA because Junit runs tests in order of filename
 */
public class AAALoadAssets extends Move {
    /**
     * Loads up Pokedex and Movedex for future use.
     */
    @Test
    public void loadPokemonAndMoves() {
        Pokedex.getPokemon("Charmander");
    }
}
