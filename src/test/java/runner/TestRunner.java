package runner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

//@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/Feature", tags = "@Successful_Login", format = {"json:target/CucumberBasic.json","html:target/site/CucumberBasic"},glue = "Steps")
public class TestRunner extends AbstractTestNGCucumberTests {
}
