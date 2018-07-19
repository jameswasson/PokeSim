package test.Regression;

public class BattleRunFile{
    long seed;
    String pokemon1;
    String pokemon2;
    int[] moveSelection;
    String correctOutput;

    public BattleRunFile(long seed, String pokemon1, String pokemon2, int[] moveSelection, String correctOutput) {
        this.seed = seed;
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
        this.moveSelection = moveSelection;
        this.correctOutput = correctOutput;
    }
}