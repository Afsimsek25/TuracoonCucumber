package StepDefinitions.LoginPage;

import Pages.OutsidePages.HomePage;
import Pages.OutsidePages.LoginRegisterPopUp;
import Utilities.BaseDriver;
import org.openqa.selenium.By;


public class LoginsSteps {
    String loginPageID;

    private final LoginRegisterPopUp loginRegisterPopUp;
    private final HomePage homePage;

    public LoginsSteps(LoginRegisterPopUp login, HomePage homePage) {
        this.loginRegisterPopUp = login;
        this.homePage = homePage;
    }
    @cucumber.api.java.en.Given("^Navigate to turacoon$")
    public void navigateToTuracoon() {
        BaseDriver.driver.get("https://tipbaks.com/en");
    }

    @cucumber.api.java.en.When("^Go to login page$")
    public void goToLoginPage() {
        loginRegisterPopUp.clickFunction(homePage.getLinkLogin());
    }

    @cucumber.api.java.en.When("^Enter username and password and click login button$")
    public void enterUsernameAndPasswordAndClickLoginButton() {
        loginRegisterPopUp.sendKeysFunction(loginRegisterPopUp.getInputLoginEmail(),"first@autotest.com");
        loginRegisterPopUp.sendKeysFunction(loginRegisterPopUp.getInputLoginPassword(),"Asimsek25");
        loginRegisterPopUp.clickFunction(loginRegisterPopUp.getButtonLogin());
    }
    @cucumber.api.java.en.Then("^User should login successfully$")
    public void userShouldLoginSuccessfully() {
       loginRegisterPopUp.verifyElementContainsText(BaseDriver.getDriver().findElement(By.cssSelector(".subscribe_button")),"Upgrade Subscription");
    }
    @cucumber.api.java.en.When("^Select Facebook option and switch window$")
    public void selectFacebookOptionAndSwitchWindow() {
        loginPageID= BaseDriver.getDriver().getWindowHandle();
        loginRegisterPopUp.clickFunction(loginRegisterPopUp.getOptionFacebook());
        for (String id:BaseDriver.getDriver().getWindowHandles()){
            if (!id.equals(loginPageID)){
                BaseDriver.getDriver().switchTo().window(id);
            }
        }
    }
    @cucumber.api.java.en.When("^Enter email and password and click login button$")
    public void enterEmailAndPasswordAndClickLoginButton() {
        loginRegisterPopUp.sendKeysFunction(loginRegisterPopUp.getInputEmailFacebook(),"asimsekfurkan@gmail.com");
        loginRegisterPopUp.sendKeysFunction(loginRegisterPopUp.getInputPasswordFacebook(),"mrcfrkn1812");
        loginRegisterPopUp.clickFunction(loginRegisterPopUp.getBtnLoginFacebook());
        BaseDriver.getDriver().switchTo().window(loginPageID);
    }
}
