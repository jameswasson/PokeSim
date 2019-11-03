import attack_states.Move;
import attack_states.moves.BubbleBeam;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class BubbleBeamTest extends MoveTest {
    Move bubbleBeam;
    @BeforeEach
    public void initBubbleBeamTests(){
        bubbleBeam = new BubbleBeam();
        MoveTest.customMoveMiss(bubbleBeam, false);
    }
    @Test
    public void triesToLowerSpd(){
        bubbleBeam.execute(Caterpie, Caterpie);
        verify(bubbleBeam.getMoveRNG(), times(1)).moveWillApplyStatus(.33);
    }
    @Test
    public void lowersSpdTest(){
        MoveTest.customMoveStatus(bubbleBeam, true);
        bubbleBeam.execute(MagikarpMock, CaterpieMock);
        verify(CaterpieMock, times(1)).changeSPD(-1);
    }
    @Test
    public void doesNotLowerSpdTest(){
        MoveTest.customMoveStatus(bubbleBeam, false);
        bubbleBeam.execute(Magikarp, CaterpieMock);
        verify(CaterpieMock, times(0)).changeSPD(anyInt());
    }
}
