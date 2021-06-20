package Pages;

import Utilities.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PricingPage extends Parent{
    public PricingPage(){
        PageFactory.initElements(BaseDriver.getDriver(), this);
    }

    @FindBy(css = "div[class='start ']")
    private List<WebElement> getStartsButtons;

    public List<WebElement> getGetStartsButtons() {
        return getStartsButtons;
    }
}
