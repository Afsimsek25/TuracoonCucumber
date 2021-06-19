package StepDefinitions.HomePage;

import Pages.HomePage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomeSteps {
    HomePage homePage = new HomePage();
    @When("^Click Create Free Account Buttons$")
    public void clickCreateFreeAccountButtons() {
        homePage.clickFunction(homePage.getBtnCreateAFreeAccount());
    }

    @Then("^User should be redirected registration page$")
    public void userShouldBeRedirectedRegistrationPage() {
        homePage.verifyElement(homePage.getRegisterForm());
    }

    @When("^User changes language$")
    public void userChangesLanguage() {
        homePage.languageAssert(homePage.getLanguageList(),homePage.getLanguageSelector());

    }

    @Then("^Page language should change$")
    public void pageLanguageShouldChange() {
        homePage.verifyElementContainsText(homePage.getBtnCreateAFreeAccount(),"ÜCRETSİZ HESAP OLUŞTUR");
    }
}
