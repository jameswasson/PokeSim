import org.junit.jupiter.api.Test;
import pokemons.Pokedex;
import pokemons.Pokemon;
import pokemons.pokemon_states.ParalyzedPokemon;
import utils.RNG;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Paralyzing extends MoveTest {
    @Test
    public void canParalyze() {
        ParalyzedPokemon.tryToParalyze(Magikarp);
        assert (ParalyzedPokemon.isParalyzed(Magikarp));
    }

    @Test
    public void paralyzeCanPreventAttack() {
        RNG.setSeed(0);
        ParalyzedPokemon.tryToParalyze(Magikarp);
        Magikarp.selectMove(tackle.getClass());
        Magikarp.attack(Caterpie);
        assertNotEquals(Caterpie.getBaseHP(), Caterpie.getCurHP());
    }

    @Test
    public void paralyzedCanAllowAttack() {
        RNG.setSeed(4096);
        Pokemon Rapidash = Pokedex.getPokemon("Rapidash");
        ParalyzedPokemon.tryToParalyze(Rapidash);
        Rapidash.selectMove(tackle.getClass());
        Rapidash.attack(Rapidash);
        assertEquals(Rapidash.getCurHP(), Rapidash.getBaseHP());
    }
}
