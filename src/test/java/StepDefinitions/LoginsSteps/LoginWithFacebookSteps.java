package StepDefinitions.LoginsSteps;

import Pages.Login;
import Utilities.BaseDriver;
import cucumber.api.java.en.When;

import java.util.Set;

public class LoginWithFacebookSteps {
    Login login = new Login();
    String loginPageID;

    @When("^Select Facebook option and switch window$")
    public void select_Facebook_option_and_switch_window(){
        loginPageID= BaseDriver.getDriver().getWindowHandle();

        login.clickFunction(login.getFacebookOption());

        Set<String> allIDs=BaseDriver.getDriver().getWindowHandles();
        for (String id:allIDs){
            if (!id.equals(loginPageID)){
                BaseDriver.getDriver().switchTo().window(id);
            }
        }
    }
    @When("^Enter email and password and click login button$")
    public void enter_email_and_password_and_click_login_button(){
        login.sendKeysFunction(login.getInputEmailFacebook(),"asimsekfurkan@gmail.com");
        login.sendKeysFunction(login.getInputPasswordFacebook(),"mrcfrkn1812");
        login.clickFunction(login.getBtnLoginFacebook());
        BaseDriver.getDriver().switchTo().window(loginPageID);

    }

}
