import attack_states.Move;
import org.junit.jupiter.api.Test;
import pokemons.pokemon_states.SleepingPokemon;
import utils.RNG;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class SleepingTests extends MoveTest {
    @Test
    public void startsNotAsleep() {
        assertFalse(SleepingPokemon.isAsleep(Caterpie));
    }

    @Test
    public void canAddSleep() {
        SleepingPokemon.tryToPutToSleep(Caterpie);
        assertTrue(SleepingPokemon.isAsleep(Caterpie));
    }

    @Test
    public void sleepPreventsAttack() {
        //pokemon are asleep for at least one turn, so this test is sufficient without RNG manipulation
        Move mockedMove = mock(Move.class);
        SleepingPokemon.tryToPutToSleep(Caterpie);
        Caterpie.selectMove(mockedMove);
        Caterpie.attack(Magikarp);
        verify(mockedMove, times(0)).execute(any(), any());
    }

    @Test
    public void sleepGoesAway() {
        RNG.setSeed(0);
        SleepingPokemon.tryToPutToSleep(Caterpie, 1);
        Caterpie.selectMove(tackle);
        Caterpie.attack(Magikarp);
        Caterpie.runPostBattleStates();
        Caterpie.selectMove(tackle);
        Caterpie.attack(Magikarp);
        assertFalse(SleepingPokemon.isAsleep(Caterpie));
    }
}
