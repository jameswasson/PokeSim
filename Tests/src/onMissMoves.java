import attack_states.Move;
import attack_states.moves.HighJumpKick;
import attack_states.moves.JumpKick;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class onMissMoves extends MoveTest {
    private Class<? extends Move> move1 = HighJumpKick.class;
    private Class<? extends Move> move2 = JumpKick.class;

    @Test
    void testMove1() {
        attackWithMove(move1);
    }

    @Test
    void testMove2() {
        attackWithMove(move2);
    }

    private void attackWithMove(Class<? extends Move> moveClass) {
        Move move = Move.getMove(moveClass);

        MoveTest.customMoveMiss(move, true);

        Caterpie.selectMove(move);
        Caterpie.attack(Magikarp);
        assertNotEquals(Caterpie.getBaseHP(), Caterpie.getCurHP());
        assertEquals(Magikarp.getBaseHP(), Magikarp.getCurHP());
    }
}
