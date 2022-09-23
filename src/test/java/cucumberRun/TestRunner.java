package cucumberRun;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        publish = true,
        features = "src/test/resources/firstTest.feature",
        glue= {"stepDefinitions"},
        plugin = { "pretty",  "html:target/cucumber-reports/cucumberReport.html"},
        monochrome = true,
        dryRun = false
)
public class TestRunner {
}
