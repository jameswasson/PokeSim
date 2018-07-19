package test.Regression;

import java.io.IOException;

import BattleField.BattleField;
import BattleField.IBattleLogger;
import Facade.FacadeFactory;
import Pokemons.IPokemon;
import Pokemons.Pokemon;
import Utils.Helpers;
import Utils.RNG;
import Utils.SelectMove.IChooseMove;
import Utils.SelectMove.TestChooseMove;
import Utils.myGson;

public class SetSimulation {
    public static String[] runSetSimulation(String file){
        BattleRunFile myFile = null;
        try {
            myFile = getBattleRunFile(file);
        }
        catch(IOException e){
            e.printStackTrace();
            return new String[] {"error","404: file not found"};
        }

        //loadFile
        //convert to object
        //prepareSeed
        RNG.setSeed(myFile.seed);
        //get pokemon
        IPokemon pokemon1 = new Pokemon(myFile.pokemon1);
        IPokemon pokemon2 = new Pokemon(myFile.pokemon2);
        //load moves
        int[] moves = myFile.moveSelection;
        ((TestChooseMove)(FacadeFactory.getInstance(IChooseMove.class))).loadMoves(moves);
        //runBattle
        int turns = 5;
        BattleField.runBattle(pokemon1,pokemon2,turns);
        //getOutput
        String test_output = FacadeFactory.getInstance(IBattleLogger.class).getLogInfo();
        return new String[] {test_output,myFile.correctOutput};
    }
    public static BattleRunFile getBattleRunFile(String file) throws IOException{
        String contents = Helpers.getFromFile(file);
        BattleRunFile battleRunFile = myGson.fromJson(contents,BattleRunFile.class);
        return battleRunFile;
    }
    public static void main(String[] args){
        BattleRunFile battleRunFile = new BattleRunFile(0,"Zubat","Zubat",new int[]{1,2,3,1,2,3,2,1},"correct");

        String s = myGson.toJson(battleRunFile);
        System.out.println(s);
    }
}
