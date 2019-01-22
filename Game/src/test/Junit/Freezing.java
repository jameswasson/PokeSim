package Junit;

import AttackStates.Moves.IceBeam;
import org.junit.Test;
import BattleStates.pre.Frozen;
public class Freezing extends Move {
    @Test
    public void canFreeze(){
        Frozen.tryToFreeze(Magikarp);
        assert(Frozen.isFrozen(Magikarp));
        Frozen.removeFreeze(Magikarp);
        assert(!Frozen.isFrozen(Magikarp));
    }
    @Test
    public void freezingMove(){
        Caterpie.selectMove(IceBeam.class);
        Caterpie.attack(Magikarp);
        assert(Frozen.isFrozen(Magikarp));
    }
    @Test
    public void freezingStopsAttack(){
        Caterpie.selectMove(IceBeam.class);
        Frozen.tryToFreeze(Caterpie);
        Caterpie.attack(Magikarp);
        assert(Magikarp.getBaseHP() - Magikarp.getCurHP()  == 0);
    }
}
