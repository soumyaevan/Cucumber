package Steps;

import Depenedenct.BaseUtil;
import Pages.loginPage;
import Tranformer.EmailTransformer;
import Tranformer.StringToInt;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.Transform;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.lang.*;
import java.util.ArrayList;
import java.util.List;

public class LoginSteps extends BaseUtil {

    private BaseUtil base;

    public LoginSteps(BaseUtil base) {
        this.base = base;
    }

    @Given("^I navigate to the login page$")
    public void iNavigateToTheLoginPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        base.driver.navigate().to("http://www.executeautomation.com/demosite/Login.html");
        System.out.println("Navigate to login page");
        Thread.sleep(3000);
    }

    /*@And("^I enter the username as soumya and password as nopass$")
    public void iEnterTheUsernameAsSoumyaAndPasswordAsNopass() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
       System.out.println("Credential Given");
    }*/

    @And("^I click on the login button$")
    public void iClickOnTheLoginButton() throws Throwable {
       // base.driver.findElement(By.name("Login")).submit();
        loginPage page = new loginPage(base.driver);
        page.loginBtnSubmit();
        System.out.println("Login button clicked");
        Thread.sleep(6000);
    }

    @Then("^I should see the userform page$")
    public void iShouldSeeTheUserformPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue("page is not displayed",base.driver.findElement(By.name("Initial")).isDisplayed());
        System.out.println("Successfully logged in");
    }

    @And("^I enter credentials$")
    public void iEnterCredentials(DataTable table) throws Throwable {
        List<User> users = new ArrayList<User>();
        users = table.asList(User.class);
        loginPage page = new loginPage(base.driver);
        for (User user : users) {
           // System.out.println("Username is: "+ user.username + " and password is: " + user.password);
            /*base.driver.findElement(By.name("UserName")).sendKeys(user.username);
            base.driver.findElement(By.name("Password")).sendKeys(user.password);*/
            page.loginCedential(user.username,user.password);
            Thread.sleep(3000);
        }
    }

    @And("^I enter ([^\"]*) and ([^\"]*)$")
    public void iEnterUsernameAndPassword(String username, String password) throws Throwable {

        System.out.println("Username is: " + username + " and Password is: " + password);
    }

    @And("^I enter the user's email:([^\"]*)$")
    public void iEnterTheUserSEmailAdmin(@Transform(EmailTransformer.class) String email) throws Throwable {
        System.out.println("The email address is: " + email);
    }

    @And("^The number of digit in salary:(\\d+)$")
    public void theNumberOfDigitInSalary(@Transform(StringToInt.class) int salary) throws Throwable {

        System.out.println("Total digit: " + salary);
    }

    @Then("^I should see the userform page wrongly$")
    public void iShouldSeeTheUserformPageWrongly() throws Throwable {
        Assert.assertTrue("page is not displayed",base.driver.findElement(By.name("vhjjvjv")).isDisplayed());
    }


    public class User {
            public String username;
            public String password;

            public User(String userName, String passWord) {
                username = userName;
                password = passWord;
            }
        }
    }
    /*@And("^I enter the username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void iEnterTheUsernameAsAndPasswordAs(String username, String password) throws Throwable {
       System.out.println("Username is: " + username + " and " + "password is: " + password);
    }*/

