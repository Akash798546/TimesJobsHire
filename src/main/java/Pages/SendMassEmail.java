package Pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.BaseTest;

public class SendMassEmail extends BaseTest {
	
	public SendMassEmail()
	{
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath = "//*[@id=\"opt_box\"]/ul[1]/li/a")
	WebElement emailhover;

	@FindBy(xpath="//*[@id=\"dd\"]/a[2]/div")
	WebElement sendemailbtn;
	
	@FindBy(id="GB_frame1")
	WebElement iframe1;
	
	@FindBy(id="GB_frame")
	WebElement iframe;
	
	@FindBy(xpath="//*[@id=\"jobDesignation\"]")
	WebElement designation;
	
	@FindBy(xpath="//*[@id=\"jobMinExp\"]")
	WebElement minexp;
	
	@FindBy(xpath="//*[@id=\"jobMaxExp\"]")
	WebElement maxexp;
	
	
	@FindBy(xpath="//div[@class=\"workpermit\"]//input[@id=\"textLocation\"]")
	WebElement location;
	
	@FindBy(xpath="(//li/label[contains(text(), 'Metros')]/following::li/input[@title='Chennai'])[1]")
	WebElement city;
	
	@FindBy(xpath="//div[@class=\"sel_wrap\"]//select[@id=\"templateId\"]")
	WebElement temp;
	
	@FindBy(xpath="//input[@name=\"fromEmailText\"]")
	WebElement emailid;
	
	@FindBy(xpath="//input[@name='replyFlag']")
	WebElement chkflag;
	
	
	@FindBy(xpath="//input[@name=\"submit1\"]")
	WebElement subbtn;
	
	@FindBy(xpath="//div[@id='confirm']")
	WebElement emailmsg;
	
	
	public void clicksendemail()
	{
		Actions action =new Actions(driver);
		action.moveToElement(emailhover).perform();
		sendemailbtn.click();
		
	}
	
	public void setDesignation() throws InterruptedException
	{
//		Thread.sleep(Duration.ofSeconds(2));
		driver.switchTo().frame(iframe1);
//		Thread.sleep(Duration.ofSeconds(2));
		driver.switchTo().frame(iframe);
//		Thread.sleep(Duration.ofSeconds(2));
		designation.sendKeys(prop.getProperty("Designation"));
//		Thread.sleep(Duration.ofSeconds(2));
	}
	
	public void setExp() throws InterruptedException
	{
		Select se=new Select(minexp);
		se.selectByIndex(2);
		Select se1=new Select(maxexp);
		se1.selectByIndex(5);
//		Thread.sleep(Duration.ofSeconds(2));
		
	}
	
	public void selectCity() throws InterruptedException
	{
		location.click();
//		Thread.sleep(Duration.ofSeconds(2));
		city.click();
		
	}
	
	public void selectTemp()
	{
		Select se2=new Select(temp);
		se2.selectByIndex(2);
	}
	
	public void setEmail()
	{
		emailid.clear();
		emailid.sendKeys(prop.getProperty("CompanyEmailId"));
		
	}
	
	public void checkFlag() throws InterruptedException
	{
		JavascriptExecutor  js=(JavascriptExecutor ) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", chkflag);
//		js.executeScript("window.scrollBy(0,3000)");
//		Thread.sleep(Duration.ofSeconds(4));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", chkflag);
	}
	
	public void clickSubmit()
	{
		subbtn.click();
	}
	
	public void verifyEmail(String text)
	{
		String email1=emailmsg.getText();
		BaseTest.verifyString(email1, text);
	}
	
}
