import attack_states.Move;
import battle_field.IBattleLogger;
import facade.FacadeFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pokemons.Pokedex;
import pokemons.Pokemon;
import pokemons.WrapperPokemon;
import utils.RNG;

import static org.mockito.Mockito.mock;

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
        RNG.setSeed(0);
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
}
