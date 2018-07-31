package test.Regression;

import BattleField.IBattleLogger;
import Facade.FacadeFactory;
import Pokemons.IPokemon;
import Pokemons.Pokemon;
import Utils.RNG;
import Utils.SelectMove.IChooseMove;
import static BattleField.BattleField.runBattle;

public class TestMaker {

    public static void main(String[] args) {
        FacadeFactory.createTestMakerEnvironment();
        String fileToStoreResult = "Test1.txt";
        long seed = 60;
        String poke1 = "Geodude";
        String poke2 = "Oddish";
        int turns = 3;

        makeTestFrom(seed,poke1,poke2,turns,fileToStoreResult);
    }

    private static void makeTestFrom(long seed, String poke1, String poke2, int turns, String file){
        RNG.setSeed(seed);
        IPokemon pokemon1 = new Pokemon(poke1);
        IPokemon pokemon2 = new Pokemon(poke2);
        runBattle(pokemon1, pokemon2, turns);

        String correctOutput = FacadeFactory.getInstance(IBattleLogger.class).getLogInfo();
        int[] chosenMoves = FacadeFactory.getInstance(IChooseMove.class).getChosenMoves();

        BattleRunFile.save(seed,poke1,poke2,chosenMoves,correctOutput);
    }
}