package Junit;

import battle_field.IBattleLogger;
import facade.FacadeFactory;
import org.junit.After;
import org.junit.Before;
import pokemons.Pokedex;
import pokemons.Pokemon;
import utils.RNG;

public class Move {
    public IBattleLogger logger;
    public Pokemon Caterpie;
    public Pokemon Magikarp;
    public Pokemon Gengar;
    public attack_states.Move tackle;

    @Before
    public void prepareEnvironment() {
        FacadeFactory.createTestingEnvironment();
        logger = FacadeFactory.getInstance(IBattleLogger.class);
        RNG.setSeed(0);
        Caterpie = Pokedex.getPokemon("Caterpie");
        Magikarp = Pokedex.getPokemon("Magikarp");
        Gengar = Pokedex.getPokemon("Gengar");
        tackle = new attack_states.moves.Tackle();
    }

    @After
    public void resetEnvironment() {
        logger.reset();
    }
}
