import attack_states.moves.Fly;
import attack_states.moves.Tackle;
import battle_states.SemiInvulnerable;
import org.junit.jupiter.api.Test;
import pokemons.Pokedex;
import pokemons.Pokemon;
import pokemons.pokemon_states.ConfusedPokemon;
import utils.RNG;

import static org.junit.jupiter.api.Assertions.*;

public class FlyingPokemonTest extends MoveTest {
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
    @Test
    public void deductsOnePP(){
        Pokemon Dodrio = Pokedex.getPokemon("Dodrio");
        int startPP = Dodrio.getMoves().get(1).getCurrentPowerPoints();
        Dodrio.selectMove(1);
        Dodrio.attack(Magikarp);
        Dodrio.runPostBattleStates();
        Dodrio.selectMove();
        Dodrio.attack(Magikarp);
        int currentPP = Dodrio.getMoves().get(1).getCurrentPowerPoints();
        assertEquals(startPP - 1, currentPP);
    }
    @Test
    public void deductsZeroPPOnCancel(){
        Pokemon Dodrio = Pokedex.getPokemon("Dodrio");
        ConfusedPokemon.tryToConfuse(Dodrio);
        int startPP = Dodrio.getMoves().get(1).getCurrentPowerPoints();
        Dodrio.selectMove(1);
        Dodrio.attack(Magikarp);
        Dodrio.runPostBattleStates();
        RNG.setSeed(0);
        Dodrio.selectMove();
        Dodrio.attack(Magikarp);
        int currentPP = Dodrio.getMoves().get(1).getCurrentPowerPoints();
        assertEquals(startPP, currentPP);
    }
    @Test
    public void CanBeCanceled(){
        Pokemon Dodrio = Pokedex.getPokemon("Dodrio");
        ConfusedPokemon.tryToConfuse(Dodrio);
        int startPP = Dodrio.getMoves().get(1).getCurrentPowerPoints();
        Dodrio.selectMove(1);
        Dodrio.attack(Magikarp);
        Dodrio.runPostBattleStates();
        RNG.setSeed(0);
        Dodrio.selectMove();
        Dodrio.attack(Magikarp);
        assertFalse(SemiInvulnerable.isSemiInvulnerable(Dodrio));
    }
}
