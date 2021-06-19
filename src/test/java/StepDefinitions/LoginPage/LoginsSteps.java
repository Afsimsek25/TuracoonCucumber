package StepDefinitions.LoginPage;

import Pages.LoginPage;
import Utilities.BaseDriver;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Set;

public class LoginsSteps {
    LoginPage login = new LoginPage();
    WebDriverWait wait = new WebDriverWait(BaseDriver.getDriver(),20);
    String loginPageID;

    @cucumber.api.java.en.Given("^Navigate to turacoon$")
    public void navigateToTuracoon() {
        BaseDriver.driver.get("https://tipbaks.com/en");
    }

    @cucumber.api.java.en.When("^Go to login page$")
    public void goToLoginPage() {
        login.clickFunction(login.getLinkLogin());
    }

    @cucumber.api.java.en.When("^Enter username and password and click login button$")
    public void enterUsernameAndPasswordAndClickLoginButton() {
        login.sendKeysFunction(login.getInputEmail(),"first@autotest.com");
        login.sendKeysFunction(login.getInputPassword(),"Asimsek25");
        login.clickFunction(login.getBtnLogin());
    }

    @cucumber.api.java.en.Then("^User should login successfully$")
    public void userShouldLoginSuccessfully() {
        wait.until(ExpectedConditions.urlContains("https://tipbaks.com/en/my-reservations"));
        Assert.assertEquals("https://tipbaks.com/en/my-reservations",BaseDriver.getDriver().getCurrentUrl(),"Failed LoginPage");
    }

    @cucumber.api.java.en.When("^Select Facebook option and switch window$")
    public void selectFacebookOptionAndSwitchWindow() {
        loginPageID= BaseDriver.getDriver().getWindowHandle();

        login.clickFunction(login.getOptionFacebook());

        Set<String> allIDs=BaseDriver.getDriver().getWindowHandles();
        for (String id:allIDs){
            if (!id.equals(loginPageID)){
                BaseDriver.getDriver().switchTo().window(id);
            }
        }

    }
    @cucumber.api.java.en.When("^Enter email and password and click login button$")
    public void enterEmailAndPasswordAndClickLoginButton() {
        login.sendKeysFunction(login.getInputEmailFacebook(),"asimsekfurkan@gmail.com");
        login.sendKeysFunction(login.getInputPasswordFacebook(),"mrcfrkn1812");
        login.clickFunction(login.getBtnLoginFacebook());
        BaseDriver.getDriver().switchTo().window(loginPageID);

    }
}
