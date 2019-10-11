import org.junit.jupiter.api.Test;
import pokemons.EleType;
import utils.RNG;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class MoveTackle extends MoveTest {
    @Test
    public void damageTest() {
        RNG.setSeed(0);
        //general test, does Move.attack work?
        //is DamageCalculator consistent?
        tackle.execute(Caterpie, Magikarp);
        tackle.execute(Magikarp, Caterpie);

        int caterpieHealthLoss = Caterpie.getBaseHP() - Caterpie.getCurHP();
        int magikarpHealthLoss = Magikarp.getBaseHP() - Magikarp.getCurHP();
        assert (caterpieHealthLoss == 21);
        assert (magikarpHealthLoss == 24);
    }

    @Test
    public void normalCannotHitGhostTest() {
        EleType GhostType = EleType.GHOST;
        EleType AnyType = EleType.NONE;
        when(CaterpieMock.getType1()).thenReturn(GhostType);
        when(CaterpieMock.getType2()).thenReturn(AnyType);
        assertTrue(tackle.noEffect(CaterpieMock));
    }

    @Test
    public void RNGTest() {
        RNG.setSeed(0);
        //makes sure DamageCalculator uses RNG and deals varying damage.
        tackle.execute(Caterpie, Magikarp);
        int curHP = Magikarp.getCurHP();
        int firstHPLoss = Magikarp.getBaseHP() - curHP;
        tackle.execute(Caterpie, Magikarp);
        int secondHPLoss = curHP - Magikarp.getCurHP();
        assert (firstHPLoss != 0);
        assert (secondHPLoss != 0);
        assert (firstHPLoss != secondHPLoss);
    }
}