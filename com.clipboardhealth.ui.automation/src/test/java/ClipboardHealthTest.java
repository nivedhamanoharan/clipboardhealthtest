import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

@CucumberOptions(
        plugin = { "pretty", "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm" },
        features = "src/test/resources/features/ClipboardHealthTest.feature",
        glue = "stepDefinitions")
@Test
@Feature("Clipboard Health Test")
public class ClipboardHealthTest extends AbstractTestNGCucumberTests {
}
