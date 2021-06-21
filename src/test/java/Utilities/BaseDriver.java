package Utilities;

import Pages.Parent;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BaseDriver {
    public static WebDriver driver;
    public static WebDriver driver2;

    public static WebDriver getDriver()
    {
        if (driver==null)
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }
    public static WebDriver getSecondDriver()
    {
        if (driver2==null)
        {
            WebDriverManager.chromedriver().setup();
            driver2 = new ChromeDriver();
            driver2.manage().window().maximize();
        }
        return driver2;
    }


    public static void DriverQuit(){
        Parent.delay(1);
        if (driver!=null){
            driver.quit();
            driver=null;
        }

    }
}
