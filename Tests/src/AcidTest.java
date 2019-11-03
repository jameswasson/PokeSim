import attack_states.Move;
import attack_states.moves.Acid;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class AcidTest extends MoveTest {
    Move acid;
    @BeforeEach
    public void initAcidTests(){
        acid = new Acid();
        MoveTest.customMoveMiss(acid, false);
    }
    @Test
    public void triesToLowerDef(){
        acid.execute(Caterpie, Caterpie);
        verify(acid.getMoveRNG(), times(1)).moveWillApplyStatus(.33);
    }
    @Test
    public void lowersDefTest(){
        MoveTest.customMoveStatus(acid, true);
        acid.execute(MagikarpMock, CaterpieMock);
        verify(CaterpieMock, times(1)).changeDEF(-1);
    }
    @Test
    public void doesNotLowerDefTest(){
        MoveTest.customMoveStatus(acid, false);
        acid.execute(Magikarp, CaterpieMock);
        verify(CaterpieMock, times(0)).changeDEF(anyInt());
    }
}
