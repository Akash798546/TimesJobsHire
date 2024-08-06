package Pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseTest;

public class ShortListing extends BaseTest {
	
	public ShortListing()
	{
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//input[@id='chk119313921']")
	WebElement chkbx1;
	
	@FindBy(xpath="//input[@id=\"chk119336862\"]")
	WebElement chkbx2;
	
	@FindBy(xpath="//input[@id='chk119336882']")
	WebElement chkbx3;
	
	@FindBy(xpath="//a[contains(text(),\"Shortlist\")]/parent::li/parent::ul[@class=\"optNavUL lft\"]")
	WebElement shortlistbtn;
	
	@FindBy(id="GB_frame1")
	WebElement iframe1;
	
	@FindBy(id="GB_frame")
	WebElement iframe;
	
	@FindBy(xpath="//input[@name='txtFolder']")
	WebElement folder;
	
	@FindBy(xpath="//input[@name='txtFolder']/following-sibling::input[@name='createButton']")
	WebElement createFolder;
	
	public void selectChk() throws InterruptedException
	{
	
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", chkbx1);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", chkbx2);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", chkbx3);
		
		Thread.sleep(Duration.ofSeconds(3));
	}
	
	public void clickSortlist()
	{
		shortlistbtn.click();
	}
	
	public void createfolder() throws InterruptedException
	{
		Thread.sleep(Duration.ofSeconds(2));
		driver.switchTo().frame(iframe1);
		driver.switchTo().frame(iframe);
		Thread.sleep(Duration.ofSeconds(2));
		folder.sendKeys(BaseTest.currentDateAndTime());
		createFolder.click();
		Thread.sleep(Duration.ofSeconds(5));
	}
	
	public void verifyfolder()
	{
		String alrt="Your folder has been successfully created!";
		BaseTest.acceptAlert(alrt);
	}
	
	public void selectFoldder()
	{
		
	}
	
	
}
