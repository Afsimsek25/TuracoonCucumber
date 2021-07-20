package pages.insidePages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.Parent;
import utils.BaseDriver;

public class DashboardPage extends Parent {

    public DashboardPage(){
        PageFactory.initElements(BaseDriver.getDriver(), this);
    }

    @FindBy(css = "div[class='card-header bg-secondary text-white'] strong")
    private WebElement textUpcomingLesson;

    public WebElement getTextUpcomingLesson() {
        return textUpcomingLesson;
    }
}
