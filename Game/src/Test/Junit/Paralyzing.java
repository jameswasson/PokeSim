package Junit;

import org.junit.Test;
import pokemons.ParalyzedPokemon;
import pokemons.Pokedex;
import pokemons.Pokemon;
import utils.RNG;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Paralyzing extends Move {
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
