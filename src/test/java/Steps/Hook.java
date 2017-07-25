package Steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook {

    @Before
    public void initializeTest(){
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
