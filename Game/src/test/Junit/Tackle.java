package test.Junit;

import org.junit.Test;

public class Tackle extends Move {
    @Test
    public void damageTest(){
        //general test, does Move.attack work?
        //is DamageCalculator consistent?
        tackle.execute(Caterpie, Magikarp);
        tackle.execute(Magikarp, Caterpie);

        int caterpieHealthLoss = Caterpie.getBaseHP() - Caterpie.getCurHP();
        int magikarpHealthLoss = Magikarp.getBaseHP() - Magikarp.getCurHP();
        assert(caterpieHealthLoss == 21);
        assert(magikarpHealthLoss == 24);
    }
    @Test
    public void RNGTest(){
        //makes sure DamageCalculator uses RNG and deals varying damage.
        tackle.execute(Caterpie, Magikarp);
        int curHP = Magikarp.getCurHP();
        int firstHPLoss = Magikarp.getBaseHP() - curHP;
        tackle.execute(Caterpie, Magikarp);
        int secondHPLoss = curHP - Magikarp.getCurHP();
        assert(firstHPLoss != 0);
        assert(secondHPLoss != 0);
        assert(firstHPLoss != secondHPLoss);
    }
}
