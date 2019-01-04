package BattleField;

public class BattleLog extends MasterLog {

    @Override
    public void print(String s) {
        System.out.print(s);
    }

    @Override
    public String getLogInfo() {
        return "This is the " + this.getClass().getSimpleName();
    }

    @Override
    public void reset(){}
}
