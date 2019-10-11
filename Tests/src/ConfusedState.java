import attack_states.Move;
import attack_states.moves.ConfuseRay;
import org.junit.jupiter.api.Test;
import utils.RNG;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class ConfusedState extends MoveTest {

    private Move mockedMove;

    @Test
    public void allowAttack() {
        RNG.setSeed(1);
        attack();
        verify(mockedMove, times(1)).execute(Magikarp, Caterpie);
    }

    @Test
    public void preventAttack() {
        RNG.setSeed(0);
        attack();
        verify(mockedMove, times(0)).execute(Magikarp, Caterpie);
    }

    public void attack() {
        mockedMove = mock(Move.class);
        Magikarp.selectMove(mockedMove);
        Caterpie.selectMove(ConfuseRay.class);
        Caterpie.attack(Magikarp);
        Magikarp.attack(Caterpie);
    }
}