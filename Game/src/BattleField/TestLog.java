package BattleField;

/**
 * Created by James on 7/3/2018.
 */

public class TestLog implements IBattleLogger {
    private static String log = "";
    @Override
    public void print(String s) {
        log += s;
    }

    @Override
    public void println(String s) {
//        print(s + "\n");
        print(s);
    }

    @Override
    public void println() {
        println("");
    }

    @Override
    public String getLogInfo() {
        return log;
    }
}
