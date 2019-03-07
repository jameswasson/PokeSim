package Junit;

import attack_states.moves.Tackle;
import attack_states.wrapper.Flinch;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlinchedState extends Move {
    @Test
    public void canFindFlinch(){
        Flinch.makeFlinch(Caterpie);
        assert(Flinch.isFlinched(Caterpie));
    }
    @Test
    public void canRemoveFlinch(){
        Caterpie.selectMove(Tackle.class);
        Flinch.makeFlinch(Caterpie);
        Caterpie.attack(Magikarp);
        Caterpie.runPostBattleStates();
        Caterpie.selectMove(Tackle.class);
        assert(!Flinch.isFlinched(Caterpie));
    }
    @Test
    public void flinchPreventsAttack(){
        Caterpie.selectMove(Tackle.class);
        Flinch.makeFlinch(Caterpie);
        Caterpie.attack(Magikarp);
        assertEquals(Magikarp.getCurHP(), Magikarp.getBaseHP());
    }
}
