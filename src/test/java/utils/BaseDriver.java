package utils;

import pages.Parent;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
            driver2.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver2.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
