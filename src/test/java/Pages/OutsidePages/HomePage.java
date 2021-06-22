package Pages.OutsidePages;

import Pages.Parent;
import Utilities.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends Parent {
    public HomePage() {
        PageFactory.initElements(BaseDriver.getDriver(), this);
    }

    @FindBy(css = "a[class='auth-option trc_ViewConent'][data-trc*='Login']")
    private WebElement linkLogin;
    @FindBy(css = "a[class='auth-option trc_ViewConent'][data-trc*='Register']")
    private WebElement linkSignup;

    @FindBy(css = "a[href*='register'][data-trc='Subscription Page']")
    private WebElement btnCreateAFreeAccount;
    @FindBy(css = "div[class='right registerRight  ']")
    private WebElement registerForm;
    @FindBy(css = "div[class='topbar d-none d-sm-block'] div[class='dropdown text-center']")
    private WebElement languageSelector;
    @FindBy(css = "div[class='topbar d-none d-sm-block'] div[class='dropdown text-center'] a[href*='tr']")
    private WebElement btnTurkish;
    @FindBy(css = "div[class='topbar d-none d-sm-block'] div[class='dropdown text-center'] a[href*='en']")
    private WebElement btnEnglish;
    @FindBy(css = "div[class='topbar d-none d-sm-block'] div[class='dropdown text-center'] a[href*='ar']")
    private WebElement btnArabic;
    @FindBy(css = "div[class='topbar d-none d-sm-block'] div[class='dropdown text-center'] a[href*='ir']")
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
