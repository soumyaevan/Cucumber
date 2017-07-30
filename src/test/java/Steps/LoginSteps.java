package Steps;

import Depenedenct.BaseUtil;
import Tranformer.EmailTransformer;
import Tranformer.StringToInt;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.Transform;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
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
    }

    /*@And("^I enter the username as soumya and password as nopass$")
    public void iEnterTheUsernameAsSoumyaAndPasswordAsNopass() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
       System.out.println("Credential Given");
    }*/

    @And("^I click on the login button$")
    public void iClickOnTheLoginButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Authentication Completed");
    }

    @Then("^I should see the userform page$")
    public void iShouldSeeTheUserformPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Successfully logged in");
    }

    @And("^I enter credentials$")
    public void iEnterCredentials(DataTable table) throws Throwable {
        List<User> users = new ArrayList<User>();
        users = table.asList(User.class);

        for (User user : users) {
            System.out.println("Username is: "+ user.username + " and password is: " + user.password);
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

