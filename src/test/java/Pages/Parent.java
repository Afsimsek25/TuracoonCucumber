package Pages;

import Utilities.BaseDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Parent {
    WebDriverWait wait;
    JavascriptExecutor js;
    public Parent(){
        wait = new WebDriverWait(BaseDriver.getDriver(),10);
        js = (JavascriptExecutor) BaseDriver.getDriver();
    }
    public void sendKeysFunction(WebElement element, String value){
        waitUntilVisible(element); // wait until element be visible
        scrollToElement(element);  //  scroll to element
        element.clear();           // clear element
        element.sendKeys(value);   //send value
    }
    public void clickFunction(WebElement element){
        waitUntilClickable(element);  //wait until element be clickable
        scrollToElement(element);     //scroll to element
        element.click();              //click.
    }
    public void waitUntilClickable(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void scrollToElement(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void waitUntilVisible(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void delay(int second)
    {
        try {
            Thread.sleep(1000*second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
