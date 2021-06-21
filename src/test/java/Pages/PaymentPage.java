package Pages;

import Utilities.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PaymentPage extends Parent{
    public PaymentPage(){
        PageFactory.initElements(BaseDriver.getDriver(), this);
    }


    @FindBy(css = "a[href='#creditCard']")
    private WebElement buttonCreditCard;
    @FindBy(css = "div.customInput:nth-child(6) > input") // don't touch never.
    private WebElement inputNameOnCard;
    @FindBy(css = "input[name='card_number']")
    private WebElement inputCardNumber;
    @FindBy(css = "input[name='expiration_month']")
    private WebElement inputMonth;
    @FindBy(css = "input[name='expiration_year']")
    private WebElement inputYear;
    @FindBy(css = "input[name='cvc']")
    private WebElement inputCvc;
    @FindBy(css = "button[class='payBtn ']")
    private WebElement buttonPay;
    @FindBy(id = "test-source-authorize-3ds")
    private WebElement authorizationFromStripe;
    @FindBy(css = ".header > h1:nth-child(2)")
    private WebElement messageSuccess;
    @FindBy(css = "div[class='customInput'] input[name='address']")
    private WebElement inputBillingAddress;
    @FindBy(css = "div[class='addressInformations'] input[name=zipCode]")
    private WebElement inputZipCode;
    @FindBy(css = "div[class='addressInformations'] input[name=city]")
    private WebElement inputCity;
    @FindBy(css = "div[class='addressInformations'] select[name='issuerCountry']")
    private Select selectCountry;


    public WebElement getInputBillingAddress() {
        return inputBillingAddress;
    }

    public WebElement getInputZipCode() {
        return inputZipCode;
    }

    public WebElement getInputCity() {
        return inputCity;
    }

    public Select getSelectCountry() {
        return selectCountry;
    }

    public WebElement getMessageSuccess() {
        return messageSuccess;
    }

    public WebElement getAuthorizationFromStripe() {
        return authorizationFromStripe;
    }

    public WebElement getInputNameOnCard() {
        return inputNameOnCard;
    }

    public WebElement getInputCardNumber() {
        return inputCardNumber;
    }

    public WebElement getInputMonth() {
        return inputMonth;
    }

    public WebElement getInputYear() {
        return inputYear;
    }

    public WebElement getInputCvc() {
        return inputCvc;
    }

    public WebElement getButtonPay() {
        return buttonPay;
    }

    public WebElement getButtonCreditCard() {
        return buttonCreditCard;
    }
}
