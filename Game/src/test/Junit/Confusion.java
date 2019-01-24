package Junit;

import attack_states.moves.ConfuseRay;
import battle_states.pre.Confused;
import org.junit.Test;
import utils.RNG;

public class Confusion extends Move {
    @Test
    public void allowAttack() {
        RNG.setSeed(1);
        attack();
        assert (Caterpie.getBaseHP() - Caterpie.getCurHP() != 0);
    }

    @Test
    public void preventAttack() {
        attack();
        assert (Caterpie.getBaseHP() - Caterpie.getCurHP() == 0);
    }

    @Test
    public void isConfusedWorks() {
        attack();
        assert (Confused.isConfused(Magikarp));
        assert (!Confused.isConfused(Caterpie));
        Magikarp.selectMove(Tackle.class);
        assert (Confused.isConfused(Magikarp));
    }

    @Test
    public void removeConfusion() {
        attack();
        Confused.removeConfusion(Magikarp);
        assert (!Confused.isConfused(Magikarp));
    }

    public void attack() {
        Magikarp.selectMove(Tackle.class);
        Caterpie.selectMove(ConfuseRay.class);
        Caterpie.attack(Magikarp);
        Magikarp.attack(Caterpie);
    }
}