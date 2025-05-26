
package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps", "hooks"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports",
                "json:target/reports/cucumberReports.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "timeline:target/cucumber-timeline"
        },
        monochrome = true,
        dryRun = false,
        tags = "@login"
)

public class RunnerTest {

}
