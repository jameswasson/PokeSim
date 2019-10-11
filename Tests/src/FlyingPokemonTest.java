import attack_states.moves.Fly;
import attack_states.moves.Tackle;
import battle_states.SemiInvulnerable;
import org.junit.jupiter.api.Test;
import pokemons.Pokedex;
import pokemons.Pokemon;
import pokemons.pokemon_states.ConfusedPokemon;
import utils.RNG;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class FlyingPokemonTest extends MoveTest {
    @Test
    public void noDamageFirstTurn() {
        Caterpie.selectMove(Fly.class);
        MoveTest.customMoveMiss(Caterpie.getSelectedMove(), false);
        Caterpie.attack(MagikarpMock);
        verify(MagikarpMock, times(0)).loseHP(anyInt(), any());
    }

    @Test
    public void damageSecondTurn() {
        Caterpie.selectMove(Fly.class);
        MoveTest.customMoveMiss(Caterpie.getSelectedMove(), false);
        Caterpie.attack(MagikarpMock);
        Caterpie.runPostBattleStates();
        Caterpie.selectMove();
        Caterpie.attack(MagikarpMock);
        verify(MagikarpMock, times(1)).loseHP(anyInt(), any());
    }

    @Test
    public void invulnerable() {
        Caterpie.selectMove(Fly.class);
        MoveTest.customMoveMiss(Caterpie.getSelectedMove(), false);
        assertFalse(Fly.isFlying((Caterpie)));
        assertFalse(SemiInvulnerable.isSemiInvulnerable(Caterpie));
        Caterpie.attack(MagikarpMock);
        assert (Fly.isFlying(Caterpie));
        assert (SemiInvulnerable.isSemiInvulnerable(Caterpie));
    }

    @Test
    public void noHurtDuringFly() {
        Caterpie.selectMove(Fly.class);
        MoveTest.customMoveMiss(Caterpie.getSelectedMove(), false);
        Caterpie.attack(Magikarp);

        Magikarp.selectMove(Tackle.class);
        MoveTest.customMoveMiss(Magikarp.getSelectedMove(), false);
        Magikarp.attack(Caterpie);
        assertEquals(Caterpie.getCurHP(), Caterpie.getCurHP());
    }

    @Test
    public void canHurtAfterFly() {
        Caterpie.selectMove(Fly.class);
        MoveTest.customMoveMiss(Caterpie.getSelectedMove(), false);
        Caterpie.attack(Magikarp);
        Caterpie.runPostBattleStates();
        Caterpie.selectMove();
        Caterpie.attack(Magikarp);
        Magikarp.selectMove(Tackle.class);
        MoveTest.customMoveMiss(Magikarp.getSelectedMove(), false);
        Magikarp.attack(Caterpie);
        assertNotEquals(Caterpie.getBaseHP(), Caterpie.getCurHP());
    }

    @Test
    public void deductsOnePP() {
        Pokemon Dodrio = Pokedex.getPokemon("Dodrio");
        Dodrio.selectMove(1);
        MoveTest.customMoveMiss(Dodrio.getSelectedMove(), false);
        int startPP = Dodrio.getSelectedMove().getCurrentPowerPoints();
        Dodrio.attack(Magikarp);
        Dodrio.runPostBattleStates();
        Dodrio.selectMove();
        Dodrio.attack(Magikarp);
        int currentPP = Dodrio.getSelectedMove().getCurrentPowerPoints();
        assertEquals(startPP - 1, currentPP);
    }

    @Test
    public void deductsZeroPPOnCancel() {
        RNG.setSeed(0);
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
    public void CanBeCanceled() {
        RNG.setSeed(0);
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
