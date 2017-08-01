package Steps;

import ConfigProperty.PropertyReader;
import Depenedenct.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Hook extends BaseUtil {

    private BaseUtil base;
    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void initializeTest(){
        System.out.println("Opening the browser");
        selectBrowser();
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

    public void selectBrowser(){
        String browser = new PropertyReader().readProperty("browser");
        System.out.println(browser);
        if (browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver","D:\\Downloads\\geckodriver-v0.16.0-win64\\geckodriver.exe");
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            capabilities.setCapability("marionette",true);
            base.driver = new FirefoxDriver();
        }
    }
}
