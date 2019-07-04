import attack_states.moves.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pokemons.Pokemon;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class SecondTurnAttacks extends MoveTest{

    private Pokemon caterpieMock;

    @BeforeEach
    void secondTurnAttacksInit(){
        caterpieMock = mock(Pokemon.class);
        when(caterpieMock.containsState(Fly.FlyingPokemon.class)).thenReturn(false);
        when(caterpieMock.containsState(Dig.DiggingPokemon.class)).thenReturn(false);
        when(caterpieMock.getCurACC()).thenReturn(1);
        when(caterpieMock.getCurEVA()).thenReturn(1);
    }

    @Test
    void skullBashDoesNotAttackFirstTurnTest(){
        when(caterpieMock.containsState(SkullBash.ChargingSkullBashPokemon.class)).thenReturn(false);
        new SkullBash().execute(caterpieMock, caterpieMock);
        verify(caterpieMock, times(0)).loseHP(anyInt(),any(SkullBash.class));
    }
    @Test
    void skyAttackDoesNotAttackFirstTurnTest(){
        when(caterpieMock.containsState(SkyAttack.ChargingSkyAttackPokemon.class)).thenReturn(false);
        new SkyAttack().execute(caterpieMock, caterpieMock);
        verify(caterpieMock, times(0)).loseHP(anyInt(),any(SkyAttack.class));
    }
    @Test
    void solarBeamDoesNotAttackFirstTurnTest(){
        when(caterpieMock.containsState(SolarBeam.ChargingSolarBeamPokemon.class)).thenReturn(false);
        new SolarBeam().execute(caterpieMock, caterpieMock);
        verify(caterpieMock, times(0)).loseHP(anyInt(),any(SolarBeam.class));
    }
    @Test
    void skullBashAttacksSecondTurn(){
        when(caterpieMock.containsState(SkullBash.ChargingSkullBashPokemon.class)).thenReturn(true);
        new SkullBash().execute(caterpieMock, caterpieMock);
        verify(caterpieMock, times(1)).loseHP(anyInt(),any(SkullBash.class));
    }
    @Test
    void skyAttackAttacksSecondTurn(){
        when(caterpieMock.containsState(SkyAttack.ChargingSkyAttackPokemon.class)).thenReturn(true);
        new SkyAttack().execute(caterpieMock, caterpieMock);
        verify(caterpieMock, times(1)).loseHP(anyInt(),any(SkyAttack.class));
    }
    @Test
    void solarBeamAttacksSecondTurn(){
        when(caterpieMock.containsState(SolarBeam.ChargingSolarBeamPokemon.class)).thenReturn(true);
        new SolarBeam().execute(caterpieMock, caterpieMock);
        verify(caterpieMock, times(1)).loseHP(anyInt(),any(SolarBeam.class));
    }
}
