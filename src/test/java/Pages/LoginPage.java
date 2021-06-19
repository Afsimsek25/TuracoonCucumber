package Pages;

import Utilities.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Parent{

    public LoginPage(){
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

    /*************************Facebook*********************************/

    @FindBy(css = "div.right:nth-child(3) > form:nth-child(1) > div:nth-child(3) > div:nth-child(2) > a")
    private WebElement optionFacebook;
    @FindBy(id = "email")
    private WebElement inputEmailFacebook;
    @FindBy(id = "pass")
    private WebElement inputPasswordFacebook;
    @FindBy(name = "login")
    private WebElement btnLoginFacebook;
    @FindBy(css = "a[class*='google']")
    private WebElement optionGoogle;

    /*************************Google*********************************/

    @FindBy(id = "identifierId")
    private WebElement inputEmailGoogle;
    @FindBy(xpath = "//*[@id=\"identifierNext\"]/div/button/span")
    private WebElement nextGoogle;
    @FindBy(css = "input[type='password']")
    private WebElement inputPasswordGoogle;


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

    public WebElement getOptionFacebook() {
        return optionFacebook;
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

    public WebElement getOptionGoogle() {
        return optionGoogle;
    }

    public WebElement getInputEmailGoogle() {
        return inputEmailGoogle;
    }

    public WebElement getNextGoogle() {
        return nextGoogle;
    }

    public WebElement getInputPasswordGoogle() {
        return inputPasswordGoogle;
    }
}
