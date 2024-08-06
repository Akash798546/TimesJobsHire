package Utils;


	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.io.FileHandler;

	import java.io.File;
	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.util.Date;

	public class CaptureScreenshot {
		
	    public static String captureScreenshot(WebDriver driver, String screenshotName) {
	        String dateName = new SimpleDateFormat(" dd-MM-yyyy-hh-mm-ss").format(new Date());
	        TakesScreenshot ts = (TakesScreenshot) driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        String destination = "D:\\Projects\\TimesJobsHire-master\\TimesJobsHire-master\\Screenshots\\" + screenshotName + dateName + ".png";
	        File finalDestination = new File(destination);
	        try {
	            FileHandler.copy(source, finalDestination);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return destination;
	        
	    }
	}



