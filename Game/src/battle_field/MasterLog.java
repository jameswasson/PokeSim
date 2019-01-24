package battle_field;

abstract class MasterLog implements IBattleLogger {


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
    public void printLogInfo() {
        System.out.println(getLogInfo());
    }
}
