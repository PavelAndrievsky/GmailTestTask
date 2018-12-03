package gmail.tests;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/java/gmail/features/",
        glue = "gmail.steps", plugin = {"pretty", "html:build/cucumber-report"}
)

public class TestRunner extends AbstractTestNGCucumberTests {
}
