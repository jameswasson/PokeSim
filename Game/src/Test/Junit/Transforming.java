package Junit;

import attack_states.moves.Transform;
import org.junit.Test;

public class Transforming extends Move {
    Class tran = Transform.class;
    @Test
    public void transform(){
        Caterpie.selectMove(tran);
        Caterpie.attack(Magikarp);
        logger.printLogInfo();
    }
}
