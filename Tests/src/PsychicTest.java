import attack_states.Move;
import attack_states.moves.Psychic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class PsychicTest extends MoveTest {
    Move psychic;
    @BeforeEach
    public void initPsychicTests(){
        psychic = new Psychic();
        MoveTest.customMoveMiss(psychic, false);
    }
    @Test
    public void triesToLowerSpc(){
        psychic.execute(Caterpie, Caterpie);
        verify(psychic.getMoveRNG(), times(1)).moveWillApplyStatus(.332);
    }
    @Test
    public void lowersSpcTest(){
        MoveTest.customMoveStatus(psychic, true);
        psychic.execute(MagikarpMock, CaterpieMock);
        verify(CaterpieMock, times(1)).changeSPC(-1);
    }
    @Test
    public void doesNotLowerAtkTest(){
        MoveTest.customMoveStatus(psychic, false);
        psychic.execute(Magikarp, CaterpieMock);
        verify(CaterpieMock, times(0)).changeSPC(anyInt());
    }
}
