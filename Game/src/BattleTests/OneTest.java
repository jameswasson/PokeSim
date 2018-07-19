package BattleTests;

import org.junit.Before;
import org.junit.Test;
import Facade.FacadeFactory;
import test.Regression.SetSimulation;

public class OneTest {

    @Before
    public void prepareTestingEnvironment(){
        FacadeFactory.createTestingEnvironment();//Loads Testing Objects
    }
    @Test
    public void runOneBattle(){
        String fileName = "BattleRunFiles//file.txt";
        String[] results = SetSimulation.runSetSimulation(fileName);

        assert results[0].equals(results[1]);
    }
}