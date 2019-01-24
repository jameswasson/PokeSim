package Junit;


import attack_states.moves.FireBlast;
import attack_states.moves.FirePunch;
import attack_states.moves.Flamethrower;
import attack_states.moves.IceBeam;
import battle_states.pre.Frozen;
import org.junit.Test;
import utils.RNG;

public class Freezing extends Move {
    @Test
    public void canFreeze() {
        Frozen.tryToFreeze(Magikarp);
        assert (Frozen.isFrozen(Magikarp));
        Frozen.removeFreeze(Magikarp);
        assert (!Frozen.isFrozen(Magikarp));
    }

    @Test
    public void freezingMove() {
        RNG.setSeed(11);
        Caterpie.selectMove(IceBeam.class);
        Caterpie.attack(Magikarp);
        assert (Frozen.isFrozen(Magikarp));
    }

    @Test
    public void freezingStopsAttack() {
        RNG.setSeed(0);
        Caterpie.selectMove(IceBeam.class);
        Frozen.tryToFreeze(Caterpie);
        Caterpie.attack(Magikarp);
        assert (Magikarp.getBaseHP() - Magikarp.getCurHP() == 0);
    }

    @Test
    public void testFireBlast() {
        burningMoveUnfreezes(FireBlast.class);
    }

    @Test
    public void testFirePunch() {
        burningMoveUnfreezes(FirePunch.class);
    }

    @Test
    public void testFlamethrower() {
        burningMoveUnfreezes(Flamethrower.class);
    }

    public void burningMoveUnfreezes(Class moveKlass) {
        Frozen.tryToFreeze(Magikarp);
        assert (Frozen.isFrozen(Magikarp));
        Caterpie.selectMove(moveKlass);
        Caterpie.attack(Magikarp);
        assert (!Frozen.isFrozen(Magikarp));
    }
}
