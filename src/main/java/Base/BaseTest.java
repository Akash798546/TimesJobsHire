package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.SecureRandom;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Utils.constants;



public class BaseTest {

	public static WebDriver driver;
	public static Properties prop;
	private WebElement element;
	public Select select;
	private static String BrowserPath="C:\\Users\\akash.gupta3\\Downloads\\Project Backup-20240619T130105Z-001\\Project Backup\\akash\\Driver\\geckodriver.exe";
	private static String configFilePath=System.getProperty("user.dir")+"\\src\\main\\java\\Config\\config.properties";
		
    private static  Random random ;
    WebElement slctTmp;
    static String expectedNormalized ;
	static String actualNormalized;
	
	public BaseTest() 
	{
		prop=new Properties();
		try {
			FileInputStream fis =new FileInputStream(configFilePath);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public static void inItBrowser()
	{
		System.out.println(prop.getProperty("browser"));
		String browser=prop.getProperty("browser");
		if(browser.equals("gecko"))
		{
			System.getProperty("webdriver.gecko.driver", BrowserPath);
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("Driver is not define");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(constants.IMPLICITLY_WAIT));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(constants.PAGE_LOAD_TIMEOUT));
		
//		driver.manage().timeouts().implicitlyWait(constants.IMPLICITLY_WAIT,TimeUnit.SECONDS);
//		driver.manage().timeouts().pageLoadTimeout(constants.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		
		String url=prop.getProperty("ApplicationURL");
		driver.get(url);
	}
	
	public static void SwitchToNewWindow()
	{
		  String originalWindow = driver.getWindowHandle();
		  Set<String> windowHandles = driver.getWindowHandles();

          // Iterate through the window handles and switch to the new window
          for (String handle : windowHandles) {
              if (!handle.equals(originalWindow)) {
                  driver.switchTo().window(handle);
                  break;
              }
          }
	}
	
	public static void SwitchToOriginalWindow()
	{
		  String originalWindow = driver.getWindowHandle();
		  driver.switchTo().window(originalWindow);
	}
	
   
	public static String randomString(String input)
	{
		SecureRandom RANDOM = new SecureRandom();
		 int randomNumber = RANDOM.nextInt(1000); // Generates a number between 0 and 999
	        return input + randomNumber;
	}
	        
	public static void selectRandomRadioBtn(List<WebElement> ele)
	{
		// Generate a random number within the range of radioButtons size
         random = new Random(System.currentTimeMillis());
         
        int randomIndex = random.nextInt(ele.size());

        // Click on the randomly selected radio button
      ele.get(randomIndex).click();
      System.out.println("Clicked on radio button: " +  ele.get(randomIndex).getAttribute("value"));
      

	}
	
	public static void verifyString(String value,String str) {
	
	try
	{
		expectedNormalized = value.replaceAll("\\s+", " ");
		 actualNormalized = str.replaceAll("\\s+", " ");
	        Assert.assertEquals(actualNormalized,expectedNormalized);

	}
	catch(Exception e)
	{
		Assert.assertEquals(value.trim(),str.trim());
	}
	}
	
	public static String currentDateAndTime()
	{
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMMyyyy EEEE HHmm");
		 String formattedDateTime = currentDateTime.format(formatter);
		return formattedDateTime;
		
	}
	
	public static void acceptAlert(String alertText)
	{
		Alert alert=driver.switchTo().alert();
		String getAlertText=alert.getText();
		expectedNormalized	=alertText.replaceAll("\\s+", " ");
		actualNormalized=alertText.replaceAll("\\s+", " ");
		System.out.println("The Expected String is : "+expectedNormalized+ " And the Actual String is : "+actualNormalized);
		
		alert.accept();
		Assert.assertEquals(expectedNormalized, actualNormalized);
		
	}
	
	

}
	
	 
	 