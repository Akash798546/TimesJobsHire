package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.BaseTest;

public class SendMassSms extends BaseTest {
	
	String ElementText;
	String tmpMsg;
	
	public SendMassSms()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"seelectAll\"]")
	WebElement smschk;
	
	@FindBy(xpath="//*[@id=\"opt_box\"]/ul[2]/li/a")
	WebElement smshover;
	
	
	@FindBy(xpath="//*[@id=\"dd2\"]/a[1]/div")
	WebElement jobassms;
	
	@FindBy(xpath="//select[@id='chosejobselectId']")
	WebElement selectjob;
	
	@FindBy(xpath="//*[@id=\"sendSmsSection\"]/div[4]/div[4]/div[1]/label[1]")
	WebElement nowradiobtn;
	
	@FindBy(id="submit1")
	WebElement submit;
	
	@FindBy(id="GB_frame1")
	WebElement iframe1;
	
	@FindBy(id="GB_frame")
	WebElement iframe;
	
	@FindBy(xpath="//*[@id=\"templatePattern\"]/div")
	List<WebElement> radiobtns;
	
	@FindBy(xpath="//*[@id=\"templateMessage\"]")
	WebElement tempmsg;

	@FindBy(xpath="//*[@id=\"confirm\"]/div[1]")
	WebElement checksms;
	
	public void sendJobAsSms()
	{
		Actions actions = new Actions(driver);

        // Perform the hover action
        actions.moveToElement(smshover).perform();
        
        jobassms.click();
	}
	
	public void chkboxbtn()
	{
		 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", smschk);
	}

	
	public void chooseJob() throws InterruptedException
	
	{  
//		Thread.sleep(Duration.ofSeconds(2));
		driver.switchTo().frame(iframe1);
//		Thread.sleep(Duration.ofSeconds(2));
		driver.switchTo().frame(iframe);
//		Thread.sleep(Duration.ofSeconds(2));
		Select se=new Select(selectjob);
		se.selectByIndex(1);
	}
	
	public void templateRadio() throws InterruptedException
	{
		for (WebElement elem : radiobtns)
		 ElementText = elem.getText();
		System.out.println("The list of elements is : "+System.lineSeparator()+ElementText);
		BaseTest.selectRandomRadioBtn(radiobtns);
		Thread.sleep(Duration.ofSeconds(2));
		tmpMsg=tempmsg.getText();
		System.out.println("The template msg is : "+tmpMsg);
	}

	public void nowRadioBtn()
	{
		nowradiobtn.click();
	}
	
	public void clickOnSbmtBtn() throws InterruptedException
	{
		submit.click();
//		Thread.sleep(Duration.ofMillis(4000));
	}
	
	public void verifyingSmsSuccessfully(String Text)
	{
		String ss=checksms.getText();
		BaseTest.verifyString(ss, Text);
	}
	
	
}
