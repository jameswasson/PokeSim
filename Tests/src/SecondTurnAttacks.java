import attack_states.Move;
import attack_states.moves.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pokemons.Pokemon;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class SecondTurnAttacks extends MoveTest {

    private Pokemon caterpieMock;
    private Move skyAttack;
    private Move skullBash;
    private Move solarBeam;

    @BeforeEach
    void secondTurnAttacksInit() {
        skyAttack = new SkyAttack();
        MoveTest.customMoveMiss(skyAttack, false);
        skullBash = new SkullBash();
        MoveTest.customMoveMiss(skullBash, false);
        solarBeam = new SolarBeam();
        MoveTest.customMoveMiss(solarBeam, false);

        caterpieMock = mock(Pokemon.class);
        when(caterpieMock.containsState(Fly.FlyingPokemon.class)).thenReturn(false);
        when(caterpieMock.containsState(Dig.DiggingPokemon.class)).thenReturn(false);
        when(caterpieMock.getCurACC()).thenReturn(1);
        when(caterpieMock.getCurEVA()).thenReturn(1);
    }

    @Test
    void skullBashDoesNotAttackFirstTurnTest() {
        when(caterpieMock.containsState(SkullBash.ChargingSkullBashPokemon.class)).thenReturn(false);
        skullBash.execute(caterpieMock, caterpieMock);
        verify(caterpieMock, times(0)).loseHP(anyInt(), any(SkullBash.class));
    }

    @Test
    void skyAttackDoesNotAttackFirstTurnTest() {
        when(caterpieMock.containsState(SkyAttack.ChargingSkyAttackPokemon.class)).thenReturn(false);
        skyAttack.execute(caterpieMock, caterpieMock);
        verify(caterpieMock, times(0)).loseHP(anyInt(), any(SkyAttack.class));
    }

    @Test
    void solarBeamDoesNotAttackFirstTurnTest() {
        when(caterpieMock.containsState(SolarBeam.ChargingSolarBeamPokemon.class)).thenReturn(false);
        solarBeam.execute(caterpieMock, caterpieMock);
        verify(caterpieMock, times(0)).loseHP(anyInt(), any(SolarBeam.class));
    }

    @Test
    void skullBashAttacksSecondTurn() {
        when(caterpieMock.containsState(SkullBash.ChargingSkullBashPokemon.class)).thenReturn(true);
        skullBash.execute(caterpieMock, caterpieMock);
        verify(caterpieMock, times(1)).loseHP(anyInt(), any(SkullBash.class));
    }

    @Test
    void skyAttackAttacksSecondTurn() {
        when(caterpieMock.containsState(SkyAttack.ChargingSkyAttackPokemon.class)).thenReturn(true);
        skyAttack.execute(caterpieMock, caterpieMock);
        verify(caterpieMock, times(1)).loseHP(anyInt(), any(SkyAttack.class));
    }

    @Test
    void solarBeamAttacksSecondTurn() {
        when(caterpieMock.containsState(SolarBeam.ChargingSolarBeamPokemon.class)).thenReturn(true);
        solarBeam.execute(caterpieMock, caterpieMock);
        verify(caterpieMock, times(1)).loseHP(anyInt(), any(SolarBeam.class));
    }
}
