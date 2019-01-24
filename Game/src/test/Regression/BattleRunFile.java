package Regression;

import Utils.Helpers;
import Utils.myGson;

public class BattleRunFile {
    private static String TestFolder = "";
    private static String runFileExtension = ".rfe";
    private static String correctOutputExtension = ".coe";
    long seed;
    String pokemon1;
    String pokemon2;
    int[] moveSelection;
    private String correctOutputFileName;
    private String id;

    private BattleRunFile(long seed, String pokemon1, String pokemon2, int[] moveSelection) {
        this.seed = seed;
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
        this.moveSelection = moveSelection;
        this.id = String.valueOf(seed) + "_" + pokemon1.substring(0, 3) + "_" + pokemon2.substring(0, 3);
        this.correctOutputFileName = this.id + correctOutputExtension;
    }

    public static void save(long seed, String pokemon1, String pokemon2, int[] moveSelection, String correctOutput) {
        BattleRunFile toSave = new BattleRunFile(seed, pokemon1, pokemon2, moveSelection);
        String data1 = myGson.toJson(toSave);
        String data2 = correctOutput;

        try {
            Helpers.writeToFile(data1, TestFolder + toSave.id + runFileExtension);
            Helpers.writeToFile(data2, TestFolder + toSave.correctOutputFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static BattleRunFile load(String filename) {
        try {
            BattleRunFile toReturn;
            String data = Helpers.getFromFile(TestFolder + filename);
            toReturn = myGson.fromJson(data, BattleRunFile.class);
            return toReturn;
        } catch (Exception e) {
            return null;
        }
    }

    public static String loadCorrectOutput(BattleRunFile battleRunFile) {
        String filename = battleRunFile.correctOutputFileName;
        try {
            return Helpers.getFromFile(TestFolder + filename);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}