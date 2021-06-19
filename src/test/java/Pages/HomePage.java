package Pages;

import Utilities.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends Parent{
    public HomePage() {
        PageFactory.initElements(BaseDriver.getDriver(), this);
    }

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
    @FindBy(xpath = "(//div[@class='dropdown-content'])[1]/p")
    private List<WebElement> languageList;


    public List<WebElement> getLanguageList() {
        return languageList;
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

    public WebElement getBtnTurkish() {
        return btnTurkish;
    }

    public WebElement getLanguageSelector() {
        return languageSelector;
    }

    public WebElement getRegisterForm() {
        return registerForm;
    }
    public WebElement getBtnCreateAFreeAccount() {
        return btnCreateAFreeAccount;
    }
}
