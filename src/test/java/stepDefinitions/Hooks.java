package stepDefinitions;

import cucumber.api.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.BaseDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Hooks {
    @Before
    public void before(Scenario scenario)
    {
        System.out.println("Senaryo başladı");
        System.out.println("scenario id si="+ scenario.getId());
        System.out.println("scenario name="+ scenario.getName());
    }

    @After
    public void after(Scenario scenario)
    {
        System.out.println("Senaryo Bitti");
        System.out.println("scenario sonucu="+ scenario.getStatus());
        System.out.println("scenario isFailed ?="+ scenario.isFailed());

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy");


        if (scenario.isFailed()) {
            TakesScreenshot screenshot = (TakesScreenshot) BaseDriver.getDriver();
            File ekranDosyasi = screenshot.getScreenshotAs(OutputType.FILE);

            try {
                FileUtils.copyFile(ekranDosyasi,
                        new File("target/FailedScreenShots/"+ scenario.getId()+date.format(formatter)+".png"));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //ExcelUtility.writeExcel("src/test/java/ApachePOI/resources/ScenarioStatus.xlsx",
               // scenario, BaseDriver.threadBrowserName.get(), date.format(formatter));

        BaseDriver.DriverQuit();
    }
}
