package Pages;

import Utilities.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginRegisterPopUp extends Parent{

    public LoginRegisterPopUp(){
        PageFactory.initElements(BaseDriver.getDriver(), this);
    }

    @FindBy(id = "email")
    private WebElement inputLoginEmail;
    @FindBy(id = "password")
    private WebElement inputLoginPassword;
    @FindBy(id = "loginBtn")
    private WebElement buttonLogin;
    @FindBy(css = "a[class='changeFormType'][data-type='register']")
    private WebElement changeFormRegister;
    @FindBy(css = "a[class='changeFormType'][data-type='login']")
    private WebElement changeFormLogin;
    @FindBy(id = "remail")
    private WebElement inputRegisterEmail;
    @FindBy(id = "rpassword")
    private WebElement inputRegisterPassword;
    @FindBy(id = "phone")
    private WebElement inputRegisterPhone;
    @FindBy(id = "rname")
    private WebElement inputRegisterName;
    @FindBy(id = "registerBtn")
    private WebElement buttonRegister;




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

    public WebElement getInputRegisterEmail() {
        return inputRegisterEmail;
    }

    public WebElement getInputRegisterPassword() {
        return inputRegisterPassword;
    }

    public WebElement getInputRegisterPhone() {
        return inputRegisterPhone;
    }

    public WebElement getInputRegisterName() {
        return inputRegisterName;
    }

    public WebElement getButtonRegister() {
        return buttonRegister;
    }

    public WebElement getChangeFormRegister() {
        return changeFormRegister;
    }

    public WebElement getChangeFormLogin() {
        return changeFormLogin;
    }

    public WebElement getInputLoginEmail() {
        return inputLoginEmail;
    }

    public WebElement getInputLoginPassword() {
        return inputLoginPassword;
    }

    public WebElement getButtonLogin() {
        return buttonLogin;
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
