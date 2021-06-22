package Pages.OutsidePages;

import Pages.Parent;
import Utilities.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SampleLessonPage extends Parent {
    public SampleLessonPage(){
        PageFactory.initElements(BaseDriver.getDriver(), this);
    }
    @FindBy(css = "div[class='tab-pane active'] a")
    private List<WebElement> sampleLessonVideos;

    public List<WebElement> getSampleLessonVideos() {
        return sampleLessonVideos;
    }
}
