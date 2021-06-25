package pages.OutsidePages;

import pages.Parent;
import utils.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BlogPage extends Parent {

    public BlogPage(){
        PageFactory.initElements(BaseDriver.getDriver(), this);
    }
    @FindBy(css = "div[class='blog col-md-12 col-lg-4']")
    private List<WebElement> blogPosts;
    @FindBy(css = "div[class='blogs']")
    private WebElement blogsContainer;

    public WebElement getBlogsContainer() {
        return blogsContainer;
    }

    public List<WebElement> getBlogPosts() {
        return blogPosts;
    }
}
