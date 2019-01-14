package BattleField;

public interface IBattleLogger {
    void print(String s);

    void println(String s);

    void println(int i);

    void println();

    String getLogInfo();

    void printLogInfo();

    void reset();
}
