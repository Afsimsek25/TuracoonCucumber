package pages.outsidePages;

import pages.Parent;
import utils.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Parent {
    public HomePage() {
        PageFactory.initElements(BaseDriver.getDriver(), this);
    }

    @FindBy(css = "div[class='auth-options'] a[href*='login']")
    private WebElement linkLogin;
    @FindBy(css = "div[class='auth-options'] a[href*='logout']")
    private WebElement linkLogout;
    @FindBy(css = "div[class='auth-options'] a[href*='register']")
    private WebElement linkSignup;

    @FindBy(css = "div[class='learn-turkish-card'] a")
    private WebElement btnCreateAFreeAccount;
    @FindBy(css = "div[class='right registerRight  ']")
    private WebElement registerForm;
    @FindBy(css = "span.d-none")
    private WebElement languageSelector;
    @FindBy(css = "a[class='dropdown-item'][href*='tr']")
    private WebElement btnTurkish;
    @FindBy(css = "a[class='dropdown-item'][href*='en']")
    private WebElement btnEnglish;
    @FindBy(css = "a[class='dropdown-item'][href*='ar']")
    private WebElement btnArabic;
    @FindBy(css = "a[class='dropdown-item'][href*='ir']")
    private WebElement btnFarsi;

    @FindBy(linkText = "Pricing")
    private WebElement btnPricingPage;

    @FindBy(linkText = "How It Works")
    private WebElement btnHowItWorks;

    @FindBy(linkText = "F.A.Q.")
    private WebElement btnFAQ;

    @FindBy(linkText = "Sample Lessons")
    private WebElement btnSampleLessons;

    @FindBy(linkText = "Tutors")
    private WebElement btnTutors;

    @FindBy(linkText = "Blog")
    private WebElement btnBlog;

    @FindBy(linkText = "Companies")
    private WebElement btnCompanies;

    public WebElement getLinkLogout() {
        return linkLogout;
    }

    public WebElement getLinkLogin() {
        return linkLogin;
    }

    public WebElement getLinkSignup() {
        return linkSignup;
    }

    public WebElement getBtnCreateAFreeAccount() {
        return btnCreateAFreeAccount;
    }

    public WebElement getRegisterForm() {
        return registerForm;
    }

    public WebElement getLanguageSelector() {
        return languageSelector;
    }

    public WebElement getBtnTurkish() {
        return btnTurkish;
    }

    public WebElement getBtnEnglish() {
        return btnEnglish;
    }

    public WebElement getBtnArabic() {
        return btnArabic;
    }

    public WebElement getBtnFarsi() {
        return btnFarsi;
    }

    public WebElement getBtnPricingPage() {
        return btnPricingPage;
    }

    public WebElement getBtnHowItWorks() {
        return btnHowItWorks;
    }

    public WebElement getBtnFAQ() {
        return btnFAQ;
    }

    public WebElement getBtnSampleLessons() {
        return btnSampleLessons;
    }

    public WebElement getBtnTutors() {
        return btnTutors;
    }

    public WebElement getBtnBlog() {
        return btnBlog;
    }

    public WebElement getBtnCompanies() {
        return btnCompanies;
    }
}
