import attack_states.Move;
import attack_states.moves.Transform;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class Transforming extends MoveTest {

    private Class<? extends Move> moveClass = Transform.class;

    @Test
    public void transform() {
        Move move = Move.getMove(moveClass);
        int originalBaseSPC = Caterpie.getBaseSPC(null);
        int originalBaseDEF = Caterpie.getBaseDEF(null);
        Caterpie.selectMove(move);
        Caterpie.attack(Gengar);
        assertEquals(Caterpie.getType1(), Gengar.getType1());
        assertEquals(Caterpie.getType2(), Gengar.getType2());
        assertEquals(Caterpie.getBaseATK(), Gengar.getBaseATK());
        assertEquals(Caterpie.getBaseSPD(), Gengar.getBaseSPD());
        assertEquals(Caterpie.getBaseDEF(null), Gengar.getBaseDEF(null));
        assertEquals(Caterpie.getBaseSPC(null), Gengar.getBaseSPC(null));

        for (int i = 0; i < Caterpie.getMoves().size(); i++) {
            assertEquals(Caterpie.getMoves().get(i).getClass(), Gengar.getMoves().get(i).getClass());
            assertEquals(5, Caterpie.getMoves().get(i).getCurrentPowerPoints());
        }

        Move criticalMove = mock(Move.class);
        Mockito.when(criticalMove.wasCritical()).thenReturn(true);

        assertEquals(Caterpie.getBaseSPC(criticalMove), originalBaseSPC);
        assertEquals(Caterpie.getBaseDEF(criticalMove), originalBaseDEF);
    }
}
