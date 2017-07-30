package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class loginPage {

    public loginPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.NAME, using = "UserName")
    public WebElement txtUsername;

    @FindBy(how = How.NAME, using = "Password")
    public WebElement txtPassword;

    @FindBy(how = How.NAME, using = "Login")
    public WebElement btnLogin;

    public void loginCedential(String usename, String password) {
        txtUsername.sendKeys(usename);
        txtPassword.sendKeys(password);
    }

    public void loginBtnSubmit(){
        btnLogin.submit();
    }

}
