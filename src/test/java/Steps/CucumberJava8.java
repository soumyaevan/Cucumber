package Steps;

import cucumber.api.PendingException;
import cucumber.api.java8.En;

public class CucumberJava8 implements En {
    public CucumberJava8() {
        And("^I want to see the step in cucumber java-(\\d+)$", (Integer arg0) -> {
            System.out.println("Language lavel is: " + arg0);
        });
    }
}
