package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"classpath:features/"},
        glue = {"steps.browser", "hooks"},
        tags = "@CreateZopaLoan",
        plugin = {
                "pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome = true)
public class ZopaHomePage extends AbstractTestNGCucumberTests {

}
