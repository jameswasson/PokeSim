package BattleField;

abstract class MasterLog implements IBattleLogger {

    @Override
    abstract public void print(String s);

    @Override
    public void println(String s) {
        print(s + "\n");
    }

    @Override
    public void println() {
        println("");
    }

    @Override
    abstract public String getLogInfo();
}
