import attack_states.moves.HighJumpKick;
import attack_states.moves.JumpKick;
import org.junit.jupiter.api.Test;
import utils.RNG;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class onMissMoves extends MoveTest {
    Class move1 = HighJumpKick.class;
    Class move2 = JumpKick.class;

    @Test
    public void testMove1() {
        attackWithMove(move1);
    }

    @Test
    public void testMove2() {
        attackWithMove(move2);
    }

    private void attackWithMove(Class move) {
        RNG.setSeed(2448);//found to miss
        Caterpie.selectMove(move);
        Caterpie.attack(Magikarp);
        assertNotEquals(Caterpie.getBaseHP(), Caterpie.getCurHP());
        assertEquals(Magikarp.getBaseHP(), Magikarp.getCurHP());
    }
}
