package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;


public class Tools extends BaseDriver {
        public static WebDriver driver;


        public static void wait(int second) {
            try {
                Thread.sleep(second * 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        public static void deleteUser (String email){
            adminPanelLogin();
            driver2.navigate().to("https://tipbaks.com/admin/students");
            WebElement searchTable = driver2.findElement(By.id("searchtable"));
            searchTable.sendKeys(email);

            WebElement btnDelete = driver2.findElement(By.cssSelector("tr:not([style='display: none;']) button[onclick^='delete']"));
            btnDelete.click();
            WebElement confirm = driver2.findElement(By.cssSelector("button[class='swal-button swal-button--confirm swal-button--danger']"));
            confirm.click();

            driver2.close();
        }


        public static void deleteUserProvider (String email){
            adminPanelLogin();
            driver2.navigate().to("https://tipbaks.com/admin/students");
            Tools.wait(1);
            WebDriverWait wait=new WebDriverWait(driver2, 60);
            WebElement searchTable=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchtable")));
            searchTable.sendKeys(email);


            WebElement deleteProvider = driver2.findElement(By.id("delete_student_from_social_provider_button"));
            JavascriptExecutor js = (JavascriptExecutor)driver2;
            js.executeScript("arguments[0].click();", deleteProvider);

            WebElement btnDelete=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("tr:not([style='display: none;']) button[onclick^='delete']")));
            btnDelete.click();

            WebElement confirm=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='swal-button swal-button--confirm swal-button--danger']")));
            confirm.click();

            driver2.close();
        }

        public static void adminPanelLogin(){
            BaseDriver.getSecondDriver();
            driver2.navigate().to("https://tipbaks.com/");

            WebElement linkLogin = driver2.findElement(By.linkText("Login"));
            linkLogin.click();
            WebElement inputEmail = driver2.findElement(By.id("email"));
            inputEmail.sendKeys("manager2020@turacoon.com");
            WebElement inputPassword = driver2.findElement(By.id("password"));
            inputPassword.sendKeys("2018Turacoon");
            WebElement btnLogin = driver2.findElement(By.id("loginBtn"));
            btnLogin.click();
            Tools.wait(3);

        }

        public static List<String> testCards(String type){
            List<String> stripeTestCards = new ArrayList<>();
            List<String> iyzicoTestCards = new ArrayList<>();

            stripeTestCards.add("4242424242424242");
            stripeTestCards.add("4000056655665556");
            stripeTestCards.add("5555555555554444");
            stripeTestCards.add("2223003122003222");
            stripeTestCards.add("5200828282828210");
            stripeTestCards.add("5105105105105100");
            stripeTestCards.add("6011111111111117");
            stripeTestCards.add("6011000990139424");
            stripeTestCards.add("4000000000003055");
            stripeTestCards.add("3566002020360505");

            iyzicoTestCards.add("5890040000000016");
            iyzicoTestCards.add("5526080000000006");
            iyzicoTestCards.add("4766620000000001");
            iyzicoTestCards.add("4603450000000000");
            iyzicoTestCards.add("4987490000000002");
            iyzicoTestCards.add("5311570000000005");
            iyzicoTestCards.add("9792020000000001");
            iyzicoTestCards.add("9792030000000000");
            iyzicoTestCards.add("5170410000000004");
            iyzicoTestCards.add("5400360000000003");

            if (type.equals("iyzico")){
                return iyzicoTestCards;
            }else{
                return stripeTestCards;
            }

        }
        public static double replacePrice(String price){
            return Double.parseDouble(price.replaceAll("[^a-zA-Z0-9.]",""));
        }

        public static void WaitForPageLoad(WebDriver driver)
        {
            waitForDocumentLoad(driver);
            waitForAjaxLoad(driver);
            waitForDocumentLoad(driver);
        }

        private static void waitForDocumentLoad(WebDriver driver)
        {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    return ((JavascriptExecutor) driver).executeScript("return  document.readyState").equals("complete");}});
        }

        private static void waitForAjaxLoad(WebDriver driver)
        {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    return driver.findElements(By.cssSelector(".waiting, .tb-loading")).size() == 0;}});
        }

}
