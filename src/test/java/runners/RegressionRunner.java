package runners;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;


@CucumberOptions(


        tags = {"@Regression"},
        features = {"src/test/java/features"},
        glue = {"stepDefinitions"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/ExtentReport/ExtentReportRegression.html"}


)
public class RegressionRunner extends AbstractTestNGCucumberTests {

    @AfterClass
    public static void afterClass() {
        Reporter.loadXMLConfig("src/test/java/XMLFiles/ExtendReportSet.xml");

        Reporter.setSystemInfo("User Name", "A.Furkan SIMSEK");
        Reporter.setSystemInfo("Application Name", "Turacoon");
        Reporter.setSystemInfo("Operating System Info", System.getProperty("os.name").toString());
        Reporter.setSystemInfo("Department", "Product Development");
        Reporter.setSystemInfo("Turacon Pre Release Sitesi", "Cucumber Test Otomasyonu");

        Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
    }

}