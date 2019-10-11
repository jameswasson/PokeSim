import attack_states.Move;
import org.junit.jupiter.api.Test;
import pokemons.pokemon_states.ParalyzedPokemon;
import utils.RNG;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class Paralyzing extends MoveTest {
    @Test
    public void canParalyze() {
        ParalyzedPokemon.tryToParalyze(Magikarp);
        assertTrue(ParalyzedPokemon.isParalyzed(Magikarp));
    }

    @Test
    public void paralyzeCanAllowAttack() {
        RNG.setSeed(0);
        Move mockedMove = mock(Move.class);
        ParalyzedPokemon.tryToParalyze(Magikarp);
        Magikarp.selectMove(mockedMove);
        Magikarp.attack(Magikarp);
        verify(mockedMove, times(1)).execute(any(), any());
    }


    @Test
    public void paralyzedCanPreventAttack() {
        RNG.setSeed(4096);
        Move mockedMove = mock(Move.class);
        ParalyzedPokemon.tryToParalyze(Magikarp);
        Magikarp.selectMove(mockedMove);
        Magikarp.attack(Magikarp);
        assertEquals(Magikarp.getCurHP(), Magikarp.getBaseHP());
        verify(mockedMove, times(0)).execute(any(), any());
    }
}
