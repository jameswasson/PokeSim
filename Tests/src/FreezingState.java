import attack_states.MoveRNG;
import attack_states.moves.FireBlast;
import attack_states.moves.FirePunch;
import attack_states.moves.Flamethrower;
import attack_states.moves.IceBeam;
import org.junit.jupiter.api.Test;
import pokemons.pokemon_states.FrozenPokemon;
import utils.RNG;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class FreezingState extends MoveTest {
    @Test
    public void canFreeze() {
        FrozenPokemon.tryToFreeze(Magikarp);
        assert (FrozenPokemon.isFrozen(Magikarp));
    }

    @Test
    public void canUnFreeze() {
        FrozenPokemon.tryToFreeze(Magikarp);
        FrozenPokemon.removeFreeze(Magikarp);
        assert (!FrozenPokemon.isFrozen(Magikarp));
    }

    @Test
    public void freezingMove() {
        Caterpie.selectMove(IceBeam.class);
        MoveTest.customMoveMiss(Caterpie.getSelectedMove(), false);
        MoveTest.customMoveStatus(Caterpie.getSelectedMove(), true);

        Caterpie.attack(Magikarp);
        assert (FrozenPokemon.isFrozen(Magikarp));
    }

    @Test
    public void freezingStopsAttack() {
        Caterpie.selectMove(tackle);
        FrozenPokemon.tryToFreeze(Caterpie);
        Caterpie.attack(MagikarpMock);
        verify(MagikarpMock, times(0)).loseHP(anyInt(), any());
    }

    @Test
    public void testFireBlast() {
        burningMoveUnfreezes(FireBlast.class);
    }

    @Test
    public void testFirePunch() {
        burningMoveUnfreezes(FirePunch.class);
    }

    @Test
    public void testFlamethrower() {
        burningMoveUnfreezes(Flamethrower.class);
    }

    public void burningMoveUnfreezes(Class moveKlass) {
        FrozenPokemon.tryToFreeze(Magikarp);
        assert (FrozenPokemon.isFrozen(Magikarp));
        Caterpie.selectMove(moveKlass);
        MoveTest.customMoveMiss(Caterpie.getSelectedMove(), false);
        Caterpie.attack(Magikarp);
        assert (!FrozenPokemon.isFrozen(Magikarp));
    }
}
