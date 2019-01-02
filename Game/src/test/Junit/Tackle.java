package test.Junit;


import BattleField.IBattleLogger;
import Pokemons.Pokedex;
import Pokemons.Pokemon;
import Utils.RNG;
import org.junit.Before;
import org.junit.Test;
import Facade.FacadeFactory;

public class Tackle {
    IBattleLogger logger;
    Pokemon Caterpie;
    Pokemon Magikarp;
    @Before
    public void prepareEnvironment(){
        FacadeFactory.createTestingEnvironment();
        logger = FacadeFactory.getInstance(IBattleLogger.class);
        RNG.setSeed(0);
        Caterpie = Pokedex.getPokemon("Caterpie");
        Magikarp = Pokedex.getPokemon("Magikarp");
    }
    @Test
    public void firstTest(){
        Caterpie.selectMove(0);
        Magikarp.selectMove(1);

        Caterpie.runPreBattleStates();
        Magikarp.runPreBattleStates();

        Caterpie.attack(Magikarp);
        Magikarp.attack(Caterpie);

        Caterpie.runPostBattleStates();
        Magikarp.runPostBattleStates();

        int caterpieHealthLoss = Caterpie.getBaseHP() - Caterpie.getCurHP();
        int magikarpHealthLoss = Magikarp.getBaseHP() - Magikarp.getCurHP();
        assert(caterpieHealthLoss == 21);
        assert(magikarpHealthLoss == 24);
    }
}
