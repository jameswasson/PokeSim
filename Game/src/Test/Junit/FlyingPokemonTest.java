package Junit;

import attack_states.moves.Fly;
import attack_states.moves.Tackle;
import battle_states.SemiInvulnerable;
import org.junit.Test;
import utils.RNG;

import static org.junit.Assert.*;

public class FlyingPokemonTest extends Move {
    @Test
    public void noDamageFirstTurn(){
        Caterpie.selectMove(Fly.class);
        Caterpie.attack(Magikarp);
        assertEquals(Caterpie.getBaseHP(), Caterpie.getCurHP());
    }
    @Test
    public void damageSecondTurn(){
        Caterpie.selectMove(Fly.class);
        Caterpie.attack(Magikarp);
        Caterpie.runPostBattleStates();
        Caterpie.selectMove();
        RNG.setSeed(0);
        Caterpie.attack(Magikarp);
        assertNotEquals(Magikarp.getBaseHP(), Magikarp.getCurHP());
    }
    @Test
    public void invulnerable(){
        Caterpie.selectMove(Fly.class);
        assertFalse(Fly.isFlying((Caterpie)));
        assertFalse(SemiInvulnerable.isSemiInvulnerable(Caterpie));
        Caterpie.attack(Magikarp);
        assert(Fly.isFlying(Caterpie));
        assert(SemiInvulnerable.isSemiInvulnerable(Caterpie));
    }
    @Test
    public void noHurtDuringFly(){
        Caterpie.selectMove(Fly.class);
        Caterpie.attack(Magikarp);
        Magikarp.selectMove(Tackle.class);
        RNG.setSeed(0);
        Magikarp.attack(Caterpie);
        assertEquals(Caterpie.getBaseHP(), Caterpie.getCurHP());
    }
    @Test
    public void canHurtAfterFly(){
        Caterpie.selectMove(Fly.class);
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
