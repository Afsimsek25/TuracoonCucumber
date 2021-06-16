package Pages;

import Utilities.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends Parent{
    public Login(){
        PageFactory.initElements(BaseDriver.getDriver(), this);
    }
    @FindBy(css = "a[href*='login']")
    private WebElement linkLogin;
    @FindBy(id = "email")
    private WebElement inputEmail;
    @FindBy(id = "password")
    private WebElement inputPassword;
    @FindBy(id = "loginBtn")
    private WebElement btnLogin;
    @FindBy(css = "div.right:nth-child(3) > form:nth-child(1) > div:nth-child(3) > div:nth-child(2) > a")
    private WebElement facebookOption;
    @FindBy(id = "email")
    private WebElement inputEmailFacebook;
    @FindBy(id = "pass")
    private WebElement inputPasswordFacebook;
    @FindBy(name = "login")
    private WebElement btnLoginFacebook;

    public WebElement getLinkLogin() {
        return linkLogin;
    }
    public WebElement getInputEmail() {
        return inputEmail;
    }
    public WebElement getInputPassword() {
        return inputPassword;
    }
    public WebElement getBtnLogin() {
        return btnLogin;
    }
    public WebElement getFacebookOption() {
        return facebookOption;
    }
    public WebElement getInputEmailFacebook() {
        return inputEmailFacebook;
    }
    public WebElement getInputPasswordFacebook() {
        return inputPasswordFacebook;
    }
    public WebElement getBtnLoginFacebook() {
        return btnLoginFacebook;
    }

}
