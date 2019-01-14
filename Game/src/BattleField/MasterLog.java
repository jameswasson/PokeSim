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
    public void println(int i) {
        println("" + i);
    }

    @Override
    abstract public String getLogInfo();

    @Override
    abstract public void reset();

    @Override
    public void printLogInfo() {
        System.out.println(getLogInfo());
    }
}
