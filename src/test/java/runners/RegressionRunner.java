package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(

        tags = {"@Regression"},
        features = {"src/test/java/FeatureFiles"},
        glue = {"stepDefinitions"},
        plugin = {"html:target/cucumber-report",
                "json:target/cucumber.json"}


)
public class RegressionRunner extends AbstractTestNGCucumberTests {

}