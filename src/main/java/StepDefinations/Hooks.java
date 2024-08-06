package StepDefinations;



import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Utils.CaptureScreenshot;
//
//
//public class Hooks {
//    WebDriver driver;
//
//    public Hooks(WebDriver driver) {
//        this.driver = driver;
//    }
//
//    @After
//    public void closeBrowser(Scenario scenario) {
//        if (scenario.isFailed()) {
//            String screenshotPath = CaptureScreenshot.captureScreenshot(driver, scenario.getName());
//            // Attach the screenshot to the scenario
//            scenario.attach(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png", scenario.getName());
//        }
//        driver.quit();
//        
//    }
//}
