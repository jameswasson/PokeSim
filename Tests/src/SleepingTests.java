import org.junit.jupiter.api.Test;
import pokemons.pokemon_states.SleepingPokemon;

import static org.junit.jupiter.api.Assertions.*;

public class SleepingTests extends MoveTest {
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
