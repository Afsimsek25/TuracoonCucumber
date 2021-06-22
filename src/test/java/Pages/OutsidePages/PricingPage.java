package Pages.OutsidePages;

import Pages.Parent;
import Utilities.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PricingPage extends Parent {
    public PricingPage(){
        PageFactory.initElements(BaseDriver.getDriver(), this);
    }

    @FindBy(css = "div[class='start ']")
    private List<WebElement> getStartsButtons;
    @FindBy(css = "div[class='bottom'] i[class='fas fa-chevron-down']")
    private WebElement buttonCustomize;
    @FindBy(css = "div[class='selectDay'] div:nth-child(3) span")
    private WebElement dayOptions5;
    @FindBy(xpath = "(//div[@class='start '])[1]")
    private WebElement getStart1;
    @FindBy(css = "div[class='buyPackage'] div[class='right']")
    private WebElement buttonTryNow;

    public WebElement getButtonTryNow() {
        return buttonTryNow;
    }
    public WebElement getGetStart1() {
        return getStart1;
    }
    public WebElement getDayOptions5() {
        return dayOptions5;
    }
    public WebElement getButtonCustomize() {
        return buttonCustomize;
    }
    public List<WebElement> getGetStartsButtons() {
        return getStartsButtons;
    }
}
