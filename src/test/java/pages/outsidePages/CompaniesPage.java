package pages.outsidePages;

import pages.Parent;
import utils.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CompaniesPage extends Parent {
    public CompaniesPage(){
        PageFactory.initElements(BaseDriver.getDriver(), this);
    }
    @FindBy(css = "a[class='getOfferBtn']")
    private List<WebElement> getQuoteButtons;

    public List<WebElement> getGetQuoteButtons() {
        return getQuoteButtons;
    }
}
