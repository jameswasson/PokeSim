import attack_states.Move;
import attack_states.MoveRNG;
import battle_field.IBattleLogger;
import facade.FacadeFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pokemons.Pokedex;
import pokemons.Pokemon;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MoveTest {
    IBattleLogger logger;
    Pokemon CaterpieMock;
    Pokemon MagikarpMock;
    Pokemon Caterpie;
    Pokemon Magikarp;
    Pokemon Gengar;
    Move tackle;

    @BeforeEach
    public void prepareEnvironment() {
        FacadeFactory.createTestingEnvironment();
        logger = FacadeFactory.getInstance(IBattleLogger.class);
        CaterpieMock = mock(Pokemon.class);
        MagikarpMock = mock(Pokemon.class);
        Caterpie = Pokedex.getPokemon("Caterpie");
        Magikarp = Pokedex.getPokemon("Magikarp");
        Gengar = Pokedex.getPokemon("Gengar");
        tackle = new attack_states.moves.Tackle();
    }

    @AfterEach
    public void resetEnvironment() {
        logger.reset();
    }

    static void customMoveMiss(Move move, boolean willMiss) {
        MoveRNG moveRNG = mock(MoveRNG.class);
        when(moveRNG.moveWillMiss(anyDouble())).thenReturn(willMiss);
        assertNotNull(move);
        move.setMoveRNG(moveRNG);
    }

    static void customMoveCrit(Move move, boolean willCrit) {
        MoveRNG moveRNG = mock(MoveRNG.class);
        when(moveRNG.moveWillCrit(anyDouble())).thenReturn(willCrit);
        assertNotNull(move);
        move.setMoveRNG(moveRNG);
    }
}
