package Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Tools extends BaseDriver {
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

        public static double replacePrice(String price){
            return Double.parseDouble(price.replaceAll("[^a-zA-Z0-9.]",""));
        }



}
