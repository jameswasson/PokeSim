package Junit;

import attack_states.moves.Dig;
import battle_states.SemiInvulnerable;
import org.junit.Before;
import org.junit.Test;
import utils.RNG;

import static org.junit.Assert.*;

public class DiggingPokemonTest extends Move {

    @Before
    public void selectStartingMove(){
        Caterpie.selectMove(Dig.class);
    }

    @Test
    public void noDamageFirstTurn(){
        Caterpie.attack(Magikarp);
        assertEquals(Caterpie.getBaseHP(), Caterpie.getCurHP());
    }
    @Test
    public void damageSecondTurn(){
        Caterpie.attack(Magikarp);
        Caterpie.runPostBattleStates();
        Caterpie.selectMove();
        RNG.setSeed(0);
        Caterpie.attack(Magikarp);
        assertNotEquals(Magikarp.getBaseHP(), Magikarp.getCurHP());
    }
    @Test
    public void invulnerable(){
        assertFalse(Dig.isDigging((Caterpie)));
        assertFalse(SemiInvulnerable.isSemiInvulnerable(Caterpie));
        Caterpie.attack(Magikarp);
        assert(Dig.isDigging(Caterpie));
        assert(SemiInvulnerable.isSemiInvulnerable(Caterpie));
    }
    @Test
    public void noHurtDuringFly(){
        Caterpie.attack(Magikarp);
        Magikarp.selectMove(Tackle.class);
        RNG.setSeed(0);
        Magikarp.attack(Caterpie);
        assertEquals(Caterpie.getBaseHP(), Caterpie.getCurHP());
    }
    @Test
    public void canHurtAfterFly(){
        Caterpie.attack(Magikarp);
        Caterpie.runPostBattleStates();
        Caterpie.selectMove();
        Caterpie.attack(Magikarp);
        Magikarp.selectMove(Tackle.class);
        RNG.setSeed(0);
        Magikarp.attack(Caterpie);
        assertNotEquals(Caterpie.getBaseHP(), Caterpie.getCurHP());
    }
}
