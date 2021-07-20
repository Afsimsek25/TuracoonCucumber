package stepDefinitions;

import pages.outsidePages.HomePage;
import pages.outsidePages.LoginRegisterPopUp;
import pages.outsidePages.PaymentPage;
import pages.outsidePages.PricingPage;
import utils.BaseDriver;
import utils.Tools;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;


public class PricingPageSteps {

    WebDriverWait wait = new WebDriverWait(BaseDriver.getDriver(), 60);
    String firstPrice;

    private final HomePage homePage;
    private final LoginRegisterPopUp loginRegisterPopUp;
    private final PaymentPage paymentPage;
    private final PricingPage pricingPage;

    public PricingPageSteps(HomePage homePage, LoginRegisterPopUp loginRegisterPopUp, PaymentPage paymentPage, PricingPage pricingPage) {
        this.homePage = homePage;
        this.loginRegisterPopUp = loginRegisterPopUp;
        this.paymentPage = paymentPage;
        this.pricingPage = pricingPage;
    }


    @When("^Go to Pricing Page$")
    public void go_to_Pricing_Page() {
        homePage.clickFunction(homePage.getBtnPricingPage());
    }

    @When("^User wants to customize the Products$")
    public void user_wants_to_customize_the_Products() {
        firstPrice = BaseDriver.getDriver().findElement(By.cssSelector("div[class='content']>div")).getText();
        pricingPage.clickFunction(pricingPage.getButtonCustomize());
        pricingPage.clickFunction(pricingPage.getDayOptions5());
    }

    @When("^User selects a product$")
    public void user_selects_a_product() {
        pricingPage.clickFunction(pricingPage.getGetStart1());
        pricingPage.clickFunction(loginRegisterPopUp.getChangeFormLogin());
    }

    @Then("^Products should be Customizable$")
    public void products_should_be_Customizable() {
        if (Tools.replacePrice(firstPrice) >= Tools.replacePrice(BaseDriver.getDriver().findElement(By.cssSelector("div[class='content']>div")).getText())) {
            Assert.fail();
        }

    }

    @Then("^After that user should be redirected to the payment page$")
    public void after_that_user_should_be_redirected_to_the_payment_page() {
        pricingPage.verifyElement(paymentPage.getButtonCreditCard());
    }


    @When("^User enters the Iyzico Card information and clicks the Buy Button$")
    public void user_enters_the_Iyzico_Card_information_and_clicks_the_Buy_Button() {
        paymentPage.sendKeysFunction(paymentPage.getInputNameOnCard(), "Automatic Purchase Iyzico");
        paymentPage.sendKeysFunction(paymentPage.getInputCardNumber(), "5890 0400 0000 0016");
        paymentPage.sendKeysFunction(paymentPage.getInputMonth(), "12");
        paymentPage.sendKeysFunction(paymentPage.getInputYear(), "24");
        paymentPage.sendKeysFunction(paymentPage.getInputCvc(), "001");

        if (paymentPage.getInputBillingAddress().isDisplayed()) {
            paymentPage.sendKeysFunction(paymentPage.getInputBillingAddress(), "Auto Test From Selenium Java by SIMSEK");
            paymentPage.sendKeysFunction(paymentPage.getInputZipCode(), "25800");
            paymentPage.sendKeysFunction(paymentPage.getInputCity(), "Erzurum");
        }
        paymentPage.clickFunction(paymentPage.getButtonPay());
    }

    @Then("^Verify Iyzico Purchase Success Message$")
    public void verify_Iyzico_Purchase_Success_Message() { //TODO refactor here

        if (BaseDriver.getDriver().getCurrentUrl().equals("https://sandbox-api.iyzipay.com/payment/mock/init3ds")) {
            System.out.println("SMS Doğrulaması Yapıldı");
            WebElement smsCode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#smsCode.form-control")));
            smsCode.sendKeys("283126");
            WebElement btnSubmit = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[id='submitBtn'][type='submit']")));
            btnSubmit.click();
            BaseDriver.getDriver().get("https://tipbaks.com/en");
        } else {
            paymentPage.verifyElement(homePage.getBtnCreateAFreeAccount());
            System.out.println("SMS Doğrulama Yapılmadı.");
        }
    }

    @When("^User enters the Stripe Card information and clicks the Buy Button$")
    public void user_enters_the_Stripe_Card_information_and_clicks_the_Buy_Button() {
        paymentPage.sendKeysFunction(paymentPage.getInputNameOnCard(), "Automatic Purchase Stripe");
        paymentPage.sendKeysFunction(paymentPage.getInputCardNumber(), "4000000000003055");
        paymentPage.sendKeysFunction(paymentPage.getInputMonth(), "12");
        paymentPage.sendKeysFunction(paymentPage.getInputYear(), "24");
        paymentPage.sendKeysFunction(paymentPage.getInputCvc(), "571");
        paymentPage.clickFunction(paymentPage.getButtonPay());
    }

    @Then("^Verify Stripe Purchase Success Message$")
    public void verify_Stripe_Purchase_Success_Message() {
        paymentPage.clickFunction(paymentPage.getAuthorizationFromStripe());
        paymentPage.verifyElement(paymentPage.getMessageSuccess());
    }

    @When("^User Select to Trial Pack$")
    public void userSelectToTrialPack() {
        pricingPage.clickFunction(pricingPage.getButtonTryNow());
    }

    @When("^Fill Register Form and click Register button$")
    public void fillRegisterFormAndClickRegisterButton() {
        pricingPage.sendKeysFunction(loginRegisterPopUp.getInputRegisterName(), "Auto from Cucumber");
        pricingPage.sendKeysFunction(loginRegisterPopUp.getInputRegisterEmail(), "trialpurchase@test.com");
        pricingPage.sendKeysFunction(loginRegisterPopUp.getInputRegisterPhone(), "05555555555");
        pricingPage.sendKeysFunction(loginRegisterPopUp.getInputRegisterPassword(), "autotest");
        pricingPage.clickFunction(loginRegisterPopUp.getButtonRegister());
    }

    @Then("^Delete the User$")
    public void deleteTheUser() {

        Tools.deleteUser("trialpurchase@test.com");
    }

    @And("^Change Form to login Enter username and password and click login button$")
    public void changeFormToLoginEnterUsernameAndPasswordAndClickLoginButton() {
        loginRegisterPopUp.clickFunction(loginRegisterPopUp.getChangeFormLogin());
        loginRegisterPopUp.sendKeysFunction(loginRegisterPopUp.getInputLoginEmail(),"first@autotest.com");
        loginRegisterPopUp.sendKeysFunction(loginRegisterPopUp.getInputLoginPassword(),"Asimsek25");
        loginRegisterPopUp.clickFunction(loginRegisterPopUp.getButtonLogin());

    }

    @When("^User Enters The Incorrect Codes$")
    public void userEntersTheIncorrectCodes() {
        paymentPage.clickFunction(paymentPage.getButtonDoYouHavePromoCode());
        paymentPage.sendKeysFunction(paymentPage.getInputPromoCode(),"FM181212");
        paymentPage.clickFunction(paymentPage.getButtonApplyPromoCode());
    }

    @Then("^Verify Promo Code Success Message$")
    public void verifyPromoCodeSuccessMessage() {
        paymentPage.verifyElementContainsText(paymentPage.getPromoCodeMessage(), "Invalid Code");
        paymentPage.verifyElementContainsText(BaseDriver.getDriver().findElement(By.cssSelector("div[class='price']")),"$99.90");
    }

    @When("^User Enters The Correct Promo Code$")
    public void userEntersTheCorrectPromoCode() {
        firstPrice=BaseDriver.getDriver().findElement(By.cssSelector("div[class='price']")).getText();
        paymentPage.clickFunction(paymentPage.getButtonDoYouHavePromoCode());
        paymentPage.sendKeysFunction(paymentPage.getInputPromoCode(),"BYIGIT5");
        paymentPage.clickFunction(paymentPage.getButtonApplyPromoCode());
    }

    @Then("^Verify Promo Code Error Message$")
    public void verifyPromoCodeErrorMessage() {
        paymentPage.verifyElementContainsText(paymentPage.getPromoCodeMessage(), "Your Promo Code Applied Successfully!");
        if (Tools.replacePrice(firstPrice)<=Tools.replacePrice(BaseDriver.getDriver().findElement(By.cssSelector("div[class='price']")).getText())){
            Assert.fail();
        }
    }

    @And("^User Click On The Upgrade Button$")
    public void userClickOnTheUpgradeButton() {
        firstPrice=BaseDriver.getDriver().findElement(By.cssSelector("div[class='price']")).getText();
        paymentPage.clickFunction(paymentPage.getButtonUpgrade());
    }

    @Then("^Verify Price Offer Must Have Increased$")
    public void verifyPriceOfferMustHaveIncreased() {
        paymentPage.verifyElement(paymentPage.getUpgradeMessage());
        if (Tools.replacePrice(firstPrice)>=Tools.replacePrice(BaseDriver.getDriver().findElement(By.cssSelector("div[class='price']")).getText())){
            Assert.fail();
        }
    }

    @When("^User Click on the element in Pricing Page$")
    public void userClickOnTheElementInPricingPage(List<WebElement> element) {

    }

    @Then("^User should be logout$")
    public void userShouldBeLogout() {
        homePage.clickFunction(homePage.getLinkLogout());
    }
}

