package utils;

import org.openqa.selenium.firefox.FirefoxDriver;
import pages.Parent;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseDriver {
    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();  // WebDriver1  , WebDriver 2
    public static ThreadLocal<String> threadBrowserName = new ThreadLocal<>(); // chrome , firefox

    public static WebDriver getDriver() {
        if (threadBrowserName.get() == null)
        {
            threadBrowserName.set("chrome");
        }
        if (threadDriver.get() == null) {
            switch (threadBrowserName.get()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    threadDriver.set( new ChromeDriver() );
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    threadDriver.set( new FirefoxDriver());
                    break;
            }
        }
        return threadDriver.get();
    }
    public static void DriverQuit() {
        Parent.delay(5);

        if (threadDriver.get() != null) {
            threadDriver.get().quit();
            WebDriver driver = threadDriver.get();
            driver =null;
            threadDriver.set(driver);
        }
    }
}
