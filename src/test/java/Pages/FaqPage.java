package Pages;

import Utilities.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FaqPage extends Parent{
    public FaqPage(){
        PageFactory.initElements(BaseDriver.getDriver(), this);
    }
    @FindBy(css = "div[data-category='Lessons']")
    private List<WebElement> howLessonsList;

    public List<WebElement> getHowLessonsList() {
        return howLessonsList;
    }
}
