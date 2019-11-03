import attack_states.Move;
import attack_states.moves.AuroraBeam;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class AuroraBeamTest extends MoveTest {
    Move auroraBeam;
    @BeforeEach
    public void initAuroraBeamTests(){
        auroraBeam = new AuroraBeam();
        MoveTest.customMoveMiss(auroraBeam, false);
    }
    @Test
    public void triesToLowerAtk(){
        auroraBeam.execute(Caterpie, Caterpie);
        verify(auroraBeam.getMoveRNG(), times(1)).moveWillApplyStatus(.33);
    }
    @Test
    public void lowersAtkTest(){
        MoveTest.customMoveStatus(auroraBeam, true);
        auroraBeam.execute(MagikarpMock, CaterpieMock);
        verify(CaterpieMock, times(1)).changeATK(-1);
    }
    @Test
    public void doesNotLowerAtkTest(){
        MoveTest.customMoveStatus(auroraBeam, false);
        auroraBeam.execute(Magikarp, CaterpieMock);
        verify(CaterpieMock, times(0)).changeATK(anyInt());
    }
}
