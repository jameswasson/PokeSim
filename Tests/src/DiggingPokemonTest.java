import attack_states.moves.Dig;
import attack_states.moves.Tackle;
import battle_states.SemiInvulnerable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pokemons.Pokedex;
import pokemons.Pokemon;
import pokemons.pokemon_states.ConfusedPokemon;
import utils.RNG;

import static org.junit.jupiter.api.Assertions.*;

public class DiggingPokemonTest extends MoveTest {

    @BeforeEach
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
    @Test
    public void deductsOnePP(){
        Pokemon Sandslash = Pokedex.getPokemon("Sandslash");
        int startPP = Sandslash.getMoves().get(1).getCurrentPowerPoints();
        Sandslash.selectMove(1);
        Sandslash.attack(Magikarp);
        Sandslash.runPostBattleStates();
        Sandslash.selectMove();
        Sandslash.attack(Magikarp);
        int currentPP = Sandslash.getMoves().get(1).getCurrentPowerPoints();
        assertEquals(startPP - 1, currentPP);
    }
    @Test
    public void deductsZeroPPOnCancel(){
        Pokemon Sandslash = Pokedex.getPokemon("Sandslash");
        ConfusedPokemon.tryToConfuse(Sandslash);
        int startPP = Sandslash.getMoves().get(1).getCurrentPowerPoints();
        Sandslash.selectMove(1);
        Sandslash.attack(Magikarp);
        Sandslash.runPostBattleStates();
        RNG.setSeed(0);
        Sandslash.selectMove();
        Sandslash.attack(Magikarp);
        int currentPP = Sandslash.getMoves().get(1).getCurrentPowerPoints();
        assertEquals(startPP, currentPP);
    }
    @Test
    public void CanBeCanceled(){
        Pokemon Sandslash = Pokedex.getPokemon("Sandslash");
        ConfusedPokemon.tryToConfuse(Sandslash);
        int startPP = Sandslash.getMoves().get(1).getCurrentPowerPoints();
        Sandslash.selectMove(1);
        Sandslash.attack(Magikarp);
        Sandslash.runPostBattleStates();
        RNG.setSeed(0);
        Sandslash.selectMove();
        Sandslash.attack(Magikarp);
        assertFalse(SemiInvulnerable.isSemiInvulnerable(Sandslash));
    }
}
