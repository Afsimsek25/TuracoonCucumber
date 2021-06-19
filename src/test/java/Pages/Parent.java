package Pages;

import Utilities.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

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
        try {
            element.click();              //click.
        }catch (Exception e){
            JavascriptExecutor executor = (JavascriptExecutor) BaseDriver.getDriver();
            executor.executeScript("arguments[0].click();", element);
        }
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
    public void verifyElementContainsText(WebElement webElement, String text) {
        wait.until(ExpectedConditions.textToBePresentInElement(webElement, text));
        Assert.assertTrue(webElement.getText().toLowerCase().contains(text.toLowerCase()));
    }
    public void verifyElement(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        Assert.assertTrue(webElement.isDisplayed());
    }
    public static void delay(int second)
    {
        try {
            Thread.sleep(1000*second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void waitUntilListLessThan(String locator) {
        wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.xpath(locator),2));
    }

    public void languageAssert(List<WebElement> list, WebElement langSelector){
        for (int i = 0; i <list.size(); i++) {
            clickFunction(langSelector);
            clickFunction(list.get(i));

            delay(3);
            Assert.assertTrue(BaseDriver.getDriver().findElement(By.cssSelector("a[href*='register'][data-trc='Subscription Page']")).isDisplayed());
        }
    }
}
