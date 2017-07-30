package Steps;

import Depenedenct.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hook extends BaseUtil {

    private BaseUtil base;
    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void initializeTest(){
        System.out.println("Opening the browser");
       System.setProperty("webdriver.gecko.driver","D:\\Software\\geckodriver-v0.15.0\\geckodriver.exe");
        base.driver = new FirefoxDriver();
    }

    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()) {
            System.out.println(scenario.getName() + " Scenario is failed");
            base.driver.close();
            base.driver.quit();
        }
        else {
            System.out.println(scenario.getName() + " Scenario is passed");
            base.driver.close();
            base.driver.quit();
        }
    }
}
