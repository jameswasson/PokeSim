package battle_field;

public class TestLog extends MasterLog {
    private String log = "";

    @Override
    public void print(String s) {
        log += s;
    }

    @Override
    public String getLogInfo() {
        return log;
    }

    @Override
    public void reset() {
        log = "";
    }
}