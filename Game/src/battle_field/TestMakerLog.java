package battle_field;

public class TestMakerLog extends MasterLog {
    private IBattleLogger testLog = new TestLog();
    private IBattleLogger printLog = new BattleLog();

    @Override
    public void print(String s) {
        testLog.print(s);
        printLog.print(s);
    }

    @Override
    public String getLogInfo() {
        return testLog.getLogInfo();
    }

    @Override
    public void reset() {
        testLog.reset();
        printLog.reset();
    }
}
