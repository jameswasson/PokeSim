import attack_states.Move;
import battle_field.IBattleLogger;
import facade.FacadeFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pokemons.Pokedex;
import pokemons.Pokemon;
import utils.RNG;

public class MoveTest {
    IBattleLogger logger;
    Pokemon Caterpie;
    Pokemon Magikarp;
    Pokemon Gengar;
    Move tackle;

    @BeforeEach
    public void prepareEnvironment() {
        FacadeFactory.createTestingEnvironment();
        logger = FacadeFactory.getInstance(IBattleLogger.class);
        RNG.setSeed(0);
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
