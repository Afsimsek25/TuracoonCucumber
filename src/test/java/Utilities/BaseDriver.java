package Utilities;

import Pages.Parent;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseDriver {
    public static WebDriver driver;

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

    public static void DriverQuit(){
        Parent.delay(3);
        if (driver!=null){
            driver.quit();
            driver=null;
        }

    }
}
