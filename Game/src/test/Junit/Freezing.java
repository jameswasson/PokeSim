package Junit;

import AttackStates.Moves.FireBlast;
import AttackStates.Moves.FirePunch;
import AttackStates.Moves.Flamethrower;
import AttackStates.Moves.IceBeam;
import Utils.RNG;
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
        RNG.setSeed(11);
        Caterpie.selectMove(IceBeam.class);
        Caterpie.attack(Magikarp);
        logger.printLogInfo();
        assert(Frozen.isFrozen(Magikarp));
    }
    @Test
    public void freezingStopsAttack(){
        RNG.setSeed(0);
        Caterpie.selectMove(IceBeam.class);
        Frozen.tryToFreeze(Caterpie);
        Caterpie.attack(Magikarp);
        assert(Magikarp.getBaseHP() - Magikarp.getCurHP()  == 0);
    }

    @Test
    public void testFireBlast(){
        burningMoveUnfreezes(FireBlast.class);
    }

    @Test
    public void testFirePunch(){
        burningMoveUnfreezes(FirePunch.class);
    }

    @Test
    public void testFlamethrower(){
        burningMoveUnfreezes(Flamethrower.class);
    }

    public void burningMoveUnfreezes(Class moveKlass){
        Frozen.tryToFreeze(Magikarp);
        assert(Frozen.isFrozen(Magikarp));
        Caterpie.selectMove(moveKlass);
        Caterpie.attack(Magikarp);
        assert(!Frozen.isFrozen(Magikarp));
    }
}
