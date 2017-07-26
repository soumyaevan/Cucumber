package Steps;

import Depenedenct.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook {

    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void initializeTest(){
        base.stepInfo = "Dependency";
        System.out.println("Before the test");
    }

    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed())
        System.out.println( scenario.getName()+" Scenario is failed");
        else
            System.out.println( scenario.getName()+" Scenario is passed");
    }
}
