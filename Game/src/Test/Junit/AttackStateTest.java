package Junit;

import attack_states.AttackState;
import facade.FacadeFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class AttackStateTest {
    Class cTackle = attack_states.moves.Tackle.class;
    String sTackle = "Tackle";

    @Before
    public void init(){
        FacadeFactory.createTestingEnvironment();
    }

    @Test
    public void getClassTest(){
        Class x = AttackState.getClass(sTackle);
        assertEquals(x, cTackle);
        x = AttackState.getClass("invalid");
        assertNull(x);
    }

    @Test
    public void getNameTest(){
        String x = AttackState.getName(cTackle);
        assertEquals(x, sTackle);
    }
}
