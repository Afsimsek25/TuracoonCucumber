package Pages;

import Utilities.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HowItWorksPage {
    public HowItWorksPage(){
        PageFactory.initElements(BaseDriver.getDriver(), this);
    }
    @FindBy(css = "div[class='content-header']")
    private List<WebElement> contentHeaders;

    public List<WebElement> getContentHeaders() {
        return contentHeaders;
    }
}
