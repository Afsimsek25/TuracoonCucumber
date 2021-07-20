package utils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
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
            getDriver().navigate().to("https://tipbaks.com/admin/students");
            WebElement searchTable = getDriver().findElement(By.id("searchtable"));
            searchTable.sendKeys(email);

            WebElement btnDelete = getDriver().findElement(By.cssSelector("tr:not([style='display: none;']) button[onclick^='delete']"));
            btnDelete.click();
            WebElement confirm = getDriver().findElement(By.cssSelector("button[class='swal-button swal-button--confirm swal-button--danger']"));
            confirm.click();

            getDriver().close();
        }


        public static void deleteUserProvider (String email){
            adminPanelLogin();
            getDriver().navigate().to("https://tipbaks.com/admin/students");
            Tools.wait(1);
            WebDriverWait wait=new WebDriverWait(getDriver(), 60);
            WebElement searchTable=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchtable")));
            searchTable.sendKeys(email);


            WebElement deleteProvider = getDriver().findElement(By.id("delete_student_from_social_provider_button"));
            JavascriptExecutor js = (JavascriptExecutor)getDriver();
            js.executeScript("arguments[0].click();", deleteProvider);

            WebElement btnDelete=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("tr:not([style='display: none;']) button[onclick^='delete']")));
            btnDelete.click();

            WebElement confirm=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='swal-button swal-button--confirm swal-button--danger']")));
            confirm.click();

            getDriver().close();
        }

        public static void adminPanelLogin(){

            BaseDriver.getDriver().get("https://tipbaks.com/en");

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            WebElement linkLogin = getDriver().findElement(By.cssSelector("div[class='auth-options'] a[href*='login']"));
            linkLogin.click();
            WebElement inputEmail = getDriver().findElement(By.id("email"));
            inputEmail.sendKeys("manager2020@turacoon.com");
            WebElement inputPassword = getDriver().findElement(By.id("password"));
            inputPassword.sendKeys("2018Turacoon");
            WebElement btnLogin = getDriver().findElement(By.id("loginBtn"));
            btnLogin.click();
            Tools.wait(3);

        }

        public static double replacePrice(String price){
            return Double.parseDouble(price.replaceAll("[^a-zA-Z0-9.]",""));
        }



}
