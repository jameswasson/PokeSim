import attack_states.moves.Dig;
import attack_states.moves.Tackle;
import battle_states.SemiInvulnerable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pokemons.Pokedex;
import pokemons.Pokemon;
import pokemons.pokemon_states.ConfusedPokemon;
import utils.RNG;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class DiggingPokemonTest extends MoveTest {

    @BeforeEach
    public void selectStartingMove() {
        Caterpie.selectMove(Dig.class);
        MoveTest.customMoveMiss(Caterpie.getSelectedMove(), false);
    }

    @Test
    public void noDamageFirstTurn() {
        Caterpie.attack(MagikarpMock);
        verify(MagikarpMock, times(0)).loseHP(anyInt(), any());
    }

    @Test
    public void damageSecondTurn() {
        Caterpie.attack(MagikarpMock);
        Caterpie.runPostBattleStates();
        Caterpie.selectMove();
        Caterpie.attack(MagikarpMock);
        verify(MagikarpMock, times(1)).loseHP(anyInt(), any());
    }

    @Test
    public void invulnerable() {
        assertFalse(Dig.isDigging((Caterpie)));
        assertFalse(SemiInvulnerable.isSemiInvulnerable(Caterpie));
        Caterpie.attack(MagikarpMock);
        assert (Dig.isDigging(Caterpie));
        assert (SemiInvulnerable.isSemiInvulnerable(Caterpie));
    }

    @Test
    public void noHurtDuringDig() {
        Caterpie.attack(Magikarp);
        Magikarp.selectMove(Tackle.class);
        Magikarp.attack(Caterpie);
        assertEquals(Caterpie.getBaseHP(), Caterpie.getCurHP());
    }

    @Test
    public void canHurtAfterDig() {
        Caterpie.attack(MagikarpMock);
        Caterpie.runPostBattleStates();
        Caterpie.selectMove();
        Caterpie.attack(MagikarpMock);
        assertFalse(SemiInvulnerable.isSemiInvulnerable(Caterpie));
    }

    @Test
    public void deductsOnePP() {
        RNG.setSeed(0);
        Pokemon Sandslash = Pokedex.getPokemon("Sandslash");
        Sandslash.selectMove(1);
        int startPP = Sandslash.getSelectedMove().getCurrentPowerPoints();
        Sandslash.attack(Magikarp);
        Sandslash.runPostBattleStates();
        Sandslash.selectMove();
        Sandslash.attack(Magikarp);
        int currentPP = Sandslash.getSelectedMove().getCurrentPowerPoints();
        assertEquals(startPP - 1, currentPP);
    }

    @Test
    public void deductsZeroPPOnCancel() {
        RNG.setSeed(0);
        Pokemon Sandslash = Pokedex.getPokemon("Sandslash");
        ConfusedPokemon.tryToConfuse(Sandslash);
        Sandslash.selectMove(1);
        int startPP = Sandslash.getSelectedMove().getCurrentPowerPoints();
        Sandslash.attack(Magikarp);
        Sandslash.runPostBattleStates();
        RNG.setSeed(0);
        Sandslash.selectMove();
        Sandslash.attack(Magikarp);
        int currentPP = Sandslash.getSelectedMove().getCurrentPowerPoints();
        assertEquals(startPP, currentPP);
    }

    @Test
    public void CanBeCanceled() {
        RNG.setSeed(0);
        Pokemon Sandslash = Pokedex.getPokemon("Sandslash");
        ConfusedPokemon.tryToConfuse(Sandslash);
        int startPP = Sandslash.getMoves().get(1).getCurrentPowerPoints();
        Sandslash.selectMove(1);
        Sandslash.attack(MagikarpMock);
        Sandslash.runPostBattleStates();
        RNG.setSeed(0);
        Sandslash.selectMove();
        Sandslash.attack(MagikarpMock);
        assertFalse(SemiInvulnerable.isSemiInvulnerable(Sandslash));
        verify(MagikarpMock, times(0)).loseHP(anyInt(), any());
    }
}
