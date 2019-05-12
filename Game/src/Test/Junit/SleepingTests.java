package Junit;

import org.junit.Test;
import pokemons.pokemon_states.SleepingPokemon;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

public class SleepingTests extends Move {
    @Test
    public void canAddSleep(){
        assertFalse(SleepingPokemon.isAsleep(Caterpie));
        SleepingPokemon.tryToPutToSleep(Caterpie);
        assertTrue(SleepingPokemon.isAsleep(Caterpie));
    }
    @Test
    public void sleepPreventsAttack(){
        SleepingPokemon.tryToPutToSleep(Caterpie);
        Caterpie.selectMove(tackle.getClass());
        Caterpie.attack(Magikarp);
        assertEquals(Magikarp.getBaseHP(), Magikarp.getCurHP());
    }
    @Test
    public void sleepGoesAway(){
        SleepingPokemon.tryToPutToSleep(Caterpie,1);
        Caterpie.selectMove(tackle.getClass());
        Caterpie.attack(Magikarp);
        assertEquals(Magikarp.getBaseHP(), Magikarp.getCurHP());
        Caterpie.runPostBattleStates();
        Caterpie.selectMove(tackle.getClass());
        Caterpie.attack(Magikarp);
        assertNotEquals(Magikarp.getBaseHP(), Magikarp.getCurHP());
    }
}
