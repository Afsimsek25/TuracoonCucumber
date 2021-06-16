package StepDefinitions.LoginsSteps;

import Pages.Login;
import Utilities.BaseDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginWithEmailSteps {
    Login login = new Login();
    WebDriverWait wait = new WebDriverWait(BaseDriver.getDriver(),20);
    @Given("^Navigate to turacoon$")
    public void navigate_to_turacoon(){
        WebDriver driver = BaseDriver.getDriver();
        driver.get("https://tipbaks.com/en");
        driver.manage().window().maximize();

    }

    @When("^Go to login page$")
    public void go_to_login_page(){
        login.clickFunction(login.getLinkLogin());
    }

    @When("^Enter username and password and click login button$")
    public void enter_username_and_password_and_click_login_button(){
        login.sendKeysFunction(login.getInputEmail(),"first@autotest.com");
        login.sendKeysFunction(login.getInputPassword(),"Asimsek25");
        login.clickFunction(login.getBtnLogin());
    }

    @Then("^User should login successfully$")
    public void user_should_login_successfully(){
        wait.until(ExpectedConditions.urlContains("https://tipbaks.com/en/my-reservations"));
        Assert.assertEquals("https://tipbaks.com/en/my-reservations",BaseDriver.getDriver().getCurrentUrl(),"Failed Login");

    }
}
