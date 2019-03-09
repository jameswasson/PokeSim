package Junit;

import attack_states.moves.Transform;
import org.junit.Test;
import pokemons.Pokemon;
import utils.RNG;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Transforming extends Move {
    @Test
    public void transform(){
        Caterpie.selectMove(Transform.class);
        Caterpie.attack(Gengar);

        assertEquals(Caterpie.getType1(), Gengar.getType1());
        assertEquals(Caterpie.getType2(), Gengar.getType2());
        assertEquals(Caterpie.getBaseATK(), Gengar.getBaseATK());
        assertEquals(Caterpie.getBaseSPD(), Gengar.getBaseSPD());
        assertEquals(Caterpie.getBaseDEF(null), Gengar.getBaseDEF(null));
        assertEquals(Caterpie.getBaseSPC(null), Gengar.getBaseSPC(null));

        for (int i = 0; i < Caterpie.getMoves().size(); i++){
            assertEquals(Caterpie.getMoves().get(i).getClass(), Gengar.getMoves().get(i).getClass());
            assertEquals(5, Caterpie.getMoves().get(i).getCurrentPowerPoints());
        }

        RNG.setSeed(0);
        Gengar.selectMove(1);
        Gengar.attack(Gengar);
        Pokemon baseCaterpie = Caterpie.getBasePokemon();
        assertEquals(Caterpie.getBaseSPC(Gengar.getAttackState()), baseCaterpie.getBaseSPC(Gengar.getAttackState()));
        assertEquals(Caterpie.getBaseDEF(Gengar.getAttackState()), baseCaterpie.getBaseDEF(Gengar.getAttackState()));
        assertNotEquals(Caterpie.getBaseSPC(null), baseCaterpie.getBaseSPC(null));
        assertNotEquals(Caterpie.getBaseDEF(null), baseCaterpie.getBaseDEF(null));
    }
}
