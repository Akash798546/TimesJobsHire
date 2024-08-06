package MyTestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/main/java/Features/QcHire.feature",
    glue = {"StepDefinations"},
    dryRun = false,
    monochrome = true,
    plugin = {"pretty", "html:target/cucumber-reports.html"}
    
)
public class TestRunner {
	
    // This class remains empty, it is used only as a holder for the above annotations
}
