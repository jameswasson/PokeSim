import attack_states.moves.Tackle;
import org.junit.jupiter.api.Test;
import pokemons.pokemon_states.FlinchedPokemon;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class FlinchedState extends MoveTest {
    @Test
    public void canFindFlinch() {
        FlinchedPokemon.makeFlinch(Caterpie);
        assert (FlinchedPokemon.isFlinched(Caterpie));
    }

    @Test
    public void removeFlichAfterTurn() {
        FlinchedPokemon.makeFlinch(Caterpie);
        Caterpie.runPostBattleStates();
        assertFalse(FlinchedPokemon.isFlinched(Caterpie));
    }

    @Test
    public void canRemoveFlinch() {
        Caterpie.selectMove(Tackle.class);
        FlinchedPokemon.makeFlinch(Caterpie);
        Caterpie.attack(Magikarp);
        Caterpie.runPostBattleStates();
        assert (!FlinchedPokemon.isFlinched(Caterpie));
    }

    @Test
    public void flinchPreventsAttack() {
        Caterpie.selectMove(Tackle.class);
        MoveTest.customMoveMiss(Caterpie.getSelectedMove(), false);
        FlinchedPokemon.makeFlinch(Caterpie);
        Caterpie.attack(MagikarpMock);
        verify(MagikarpMock, times(0)).loseHP(anyInt(), any());
    }
}
