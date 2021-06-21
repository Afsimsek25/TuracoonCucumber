package StepDefinitions.HomePage;

import Pages.*;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomeSteps {

    private final HomePage homePage;
    private final PricingPage pricingPage;
    private final HowItWorksPage howItWorksPage;
    private final FaqPage faqPage;
    private final SampleLessonPage sampleLessonPage;
    private final TutorsPage tutorsPage;
    private final BlogPage blogPage;
    private final CompaniesPage companiesPage;

    public HomeSteps(HomePage homePage, PricingPage pricingPage, HowItWorksPage howItWorksPage, FaqPage faqPage, SampleLessonPage sampleLessonPage, TutorsPage tutorsPage, BlogPage blogPage, CompaniesPage companiesPage) {
        this.homePage = homePage;
        this.pricingPage = pricingPage;
        this.howItWorksPage = howItWorksPage;
        this.faqPage = faqPage;
        this.sampleLessonPage = sampleLessonPage;
        this.tutorsPage = tutorsPage;
        this.blogPage = blogPage;
        this.companiesPage = companiesPage;
    }


    @When("^Click Create Free Account Buttons$")
    public void clickCreateFreeAccountButtons() {
        homePage.clickFunction(homePage.getBtnCreateAFreeAccount());
    }

    @Then("^User should be redirected registration page$")
    public void userShouldBeRedirectedRegistrationPage() {
        homePage.verifyElement(homePage.getRegisterForm());
    }


    @When("^User clicks on the Turkish option$")
    public void userClicksOnTheTurkishOption() {
        homePage.clickFunction(homePage.getLanguageSelector());
        homePage.clickFunction(homePage.getBtnTurkish());
    }

    @Then("^Page language should be Turkish$")
    public void pageLanguageShouldBeTurkish() {
        homePage.verifyElementContainsText(homePage.getBtnCreateAFreeAccount(),"ÜCRETSİZ HESAP OLUŞTUR");
    }

    @When("^User clicks on the English option$")
    public void userClicksOnTheEnglishOption() {
        homePage.clickFunction(homePage.getLanguageSelector());
        homePage.clickFunction(homePage.getBtnEnglish());
    }

    @Then("^Page language should be English$")
    public void pageLanguageShouldBeEnglish() {
        homePage.verifyElementContainsText(homePage.getBtnCreateAFreeAccount(),"CREATE A FREE ACCOUNT");
    }

    @When("^User clicks on the Arabic option$")
    public void userClicksOnTheArabicOption() {
        homePage.clickFunction(homePage.getLanguageSelector());
        homePage.clickFunction(homePage.getBtnArabic());
    }

    @Then("^Page language should be Arabic$")
    public void pageLanguageShouldBeArabic() {
        homePage.verifyElementContainsText(homePage.getBtnCreateAFreeAccount(),"أنشئ حساب مجاني");
    }

    @When("^User clicks on the Persian option$")
    public void userClicksOnThePersianOption() {
        homePage.clickFunction(homePage.getLanguageSelector());
        homePage.clickFunction(homePage.getBtnFarsi());
    }

    @Then("^Page language should be Persian$")
    public void pageLanguageShouldBePersian() {
        homePage.verifyElementContainsText(homePage.getBtnCreateAFreeAccount(),"یک حساب کاربری رایگان بساز");
    }

    @When("^User clicks on the Pricing Page$")
    public void userClicksOnThePricingPage() {
        homePage.clickFunction(homePage.getBtnPricingPage());
    }

    @Then("^User should be redirected Pricing Page$")
    public void userShouldBeRedirectedPricingPage() {
        pricingPage.numberOfElements(pricingPage.getGetStartsButtons(),4);
    }

    @When("^User clicks on the HowItWorks Page$")
    public void userClicksOnTheHowItWorksPage() {
        homePage.clickFunction(homePage.getBtnHowItWorks());
    }

    @Then("^User should be redirected HowItWorks Page$")
    public void userShouldBeRedirectedHowItWorksPage() {
        pricingPage.numberOfElements(howItWorksPage.getContentHeaders(),4);
    }

    @When("^User clicks on the FAQ Page$")
    public void userClicksOnTheFAQPage() {
        homePage.clickFunction(homePage.getBtnFAQ());
    }

    @Then("^User should be redirected FAQ Page$")
    public void userShouldBeRedirectedFAQPage() {
        faqPage.numberOfElements(faqPage.getHowLessonsList(),9);
    }

    @When("^User clicks on the SampleLesson Page$")
    public void userClicksOnTheSampleLessonPage() {
        homePage.clickFunction(homePage.getBtnSampleLessons());
    }

    @Then("^User should be redirected SampleLesson Page$")
    public void userShouldBeRedirectedSampleLessonPage() {
        sampleLessonPage.numberOfElements(sampleLessonPage.getSampleLessonVideos(),9);
    }

    @When("^User clicks on the Tutors Page$")
    public void userClicksOnTheTutorsPage() {
        homePage.clickFunction(homePage.getBtnTutors());
    }

    @Then("^User should be redirected Tutors Page$")
    public void userShouldBeRedirectedTutorsPage(){
        tutorsPage.verifyElement(tutorsPage.getTutorsContainer());
    }

    @When("^User clicks on the Blog Page$")
    public void userClicksOnTheBlogPage() {
        homePage.clickFunction(homePage.getBtnBlog());
    }

    @Then("^User should be redirected Blog Page$")
    public void userShouldBeRedirectedBlogPage() {
        blogPage.verifyElement(blogPage.getBlogsContainer());

    }

    @When("^User clicks on the Companies Page$")
    public void userClicksOnTheCompaniesPage() {
        homePage.clickFunction(homePage.getBtnCompanies());
    }

    @Then("^User should be redirected Companies Page$")
    public void userShouldBeRedirectedCompaniesPage() {
        companiesPage.numberOfElements(companiesPage.getGetQuoteButtons(),3);

    }
}
