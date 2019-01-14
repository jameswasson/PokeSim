package Junit;

import BattleField.IBattleLogger;
import Facade.FacadeFactory;
import Pokemons.Pokedex;
import Pokemons.Pokemon;
import Utils.RNG;
import org.junit.After;
import org.junit.Before;

public class Move {
    public IBattleLogger logger;
    public Pokemon Caterpie;
    public Pokemon Magikarp;
    public AttackStates.Move tackle;

    @Before
    public void prepareEnvironment() {
        FacadeFactory.createTestingEnvironment();
        logger = FacadeFactory.getInstance(IBattleLogger.class);
        RNG.setSeed(0);
        Caterpie = Pokedex.getPokemon("Caterpie");
        Magikarp = Pokedex.getPokemon("Magikarp");
        tackle = new AttackStates.Moves.Tackle();
    }

    @After
    public void resetEnvironment() {
        logger.reset();
    }
}
