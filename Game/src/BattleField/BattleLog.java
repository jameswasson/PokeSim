package BattleField;

/**
 * Created by James on 7/3/2018.
 */

public class BattleLog implements IBattleLogger{

    @Override
    public void print(String s) {
        System.out.print(s);
    }

    @Override
    public void println(String s) {
        print(s + "\n");
    }

    @Override
    public void println() {
        println("");
    }

    @Override
    public String getLogInfo() {
        return "This is the " + this.getClass().getSimpleName();
    }
}
