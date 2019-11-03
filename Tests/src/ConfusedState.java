import attack_states.Move;
import attack_states.moves.ConfuseRay;
import attack_states.moves.Confusion;
import org.junit.jupiter.api.Test;
import pokemons.pokemon_states.ConfusedPokemon;
import utils.RNG;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class ConfusedState extends MoveTest {

    private Move mockedMove;

    @Test
    public void allowAttack() {
        RNG.setSeed(1);
        mockedMove = mock(Move.class);
        Magikarp.selectMove(mockedMove);
        ConfusedPokemon.tryToConfuse(Magikarp);

        Magikarp.attack(Caterpie);
        verify(mockedMove, times(1)).execute(Magikarp, Caterpie);
    }

    @Test
    public void preventAttack() {
        RNG.setSeed(2000);
        mockedMove = mock(Move.class);
        Magikarp.selectMove(mockedMove);
        ConfusedPokemon.tryToConfuse(Magikarp);

        Magikarp.attack(Caterpie);
        verify(mockedMove, times(0)).execute(Magikarp, Caterpie);
    }
}