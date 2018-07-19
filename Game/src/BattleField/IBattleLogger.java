package BattleField;

/**
 * Created by James on 7/3/2018.
 */

public interface IBattleLogger {
    void print(String s);
    void println(String s);
    void println();

    String getLogInfo();
}
