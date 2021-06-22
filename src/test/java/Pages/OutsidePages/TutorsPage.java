package Pages.OutsidePages;

import Pages.Parent;
import Utilities.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TutorsPage extends Parent {
    public TutorsPage(){
        PageFactory.initElements(BaseDriver.getDriver(), this);
    }

    @FindBy(css = "div[class='col-12 col-lg-4 mt-4 tutorContent']")
    private List<WebElement> allTutors;
    @FindBy(css = "div[class='container containerTutors']")
    private WebElement tutorsContainer;

    public WebElement getTutorsContainer() {
        return tutorsContainer;
    }

    public List<WebElement> getAllTutors() {
        return allTutors;
    }
}
