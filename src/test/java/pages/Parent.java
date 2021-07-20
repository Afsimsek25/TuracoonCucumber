package pages;

import utils.BaseDriver;
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

    public Parent() {
        wait = new WebDriverWait(BaseDriver.getDriver(), 10);
        js = (JavascriptExecutor) BaseDriver.getDriver();
    }

    public void sendKeysFunction(WebElement element, String value) {
        waitUntilVisible(element); // wait until element be visible
        scrollToElement(element);  //  scroll to element
        element.clear();           // clear element
        element.sendKeys(value);   //send value
    }

    public void clickFunction(WebElement element) {
        waitUntilClickable(element);  //wait until element be clickable
        scrollToElement(element);     //scroll to element
        try {
            element.click();          //click.
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) BaseDriver.getDriver();
            executor.executeScript("arguments[0].click();", element);
        }
    }

    public void waitUntilClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void scrollToElement(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void scrollToUpElement(WebElement element) {
        js.executeScript("arguments[0].setAttribute('style', 'top:0px')", element);
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void waitUntilVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void verifyElementContainsText(WebElement webElement, String text) {
        wait.until(ExpectedConditions.textToBePresentInElement(webElement, text));
        Assert.assertTrue(webElement.getText().toLowerCase().contains(text.toLowerCase()));
    }

    public void verifyElement(WebElement webElement) { // Element is Displayed
        wait.until(ExpectedConditions.visibilityOf(webElement));
        Assert.assertTrue(webElement.isDisplayed());
    }
    public static void delay(int second) // Be careful! Using Thread.sleep is the wrong approach!
    {
        try {
            Thread.sleep(1000L * second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void numberOfElements(List<WebElement> element, int piece) { // We check if the list of elements is the number we went...**/
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
        Assert.assertEquals(element.size(), piece);
    }

    public void elementsToBeMoreThan(String locator, int piece) { // The number of teachers should not be less than "piece"...**/
        wait.until(ExpectedConditions.visibilityOfAllElements());
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(locator), piece));
    }

    public void elementsToBeMoreThan(List<WebElement> element, String locator, int piece) { // The number of teachers should not be less than "piece"...**/
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(locator), piece));
    }

    public void listSelectOption(List<WebElement> list, String option) // will click on the desired element from the list
    {
        for (WebElement e : list) {
            if (e.getText().contains(option)) {
                e.click();
                break;
            }
        }
    }


}
