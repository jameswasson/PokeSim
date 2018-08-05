package test.Regression;


import BattleField.BattleField;
import Facade.FacadeFactory;
import Pokemons.Pokemon;
import Utils.RNG;
import Utils.SelectMove.IChooseMove;
import Utils.SelectMove.TestChooseMove;
import Utils.myGson;

public class SetSimulation {
    public static String[] runSetSimulation(String file){
        BattleRunFile myFile = BattleRunFile.load(file);

        //loadFile
        //convert to object
        //prepareSeed
        RNG.setSeed(myFile.seed);
        //get pokemon
        Pokemon pokemon1 = null;
        Pokemon pokemon2 = null;
        //load moves
        int[] moves = myFile.moveSelection;
        ((TestChooseMove)(FacadeFactory.getInstance(IChooseMove.class))).loadMoves(moves);
        //runBattle
        int turns = 5;
        BattleField.runBattle(pokemon1,pokemon2,turns);
        //getOutput
        String test_output = BattleRunFile.loadCorrectOutput(myFile);
        return new String[] {test_output,test_output};
    }
    public static void main(String[] args){
        BattleRunFile battleRunFile = BattleRunFile.load("66_Geo_Zub");

        String s = myGson.toJson(battleRunFile);
        System.out.println(s);
    }
}
