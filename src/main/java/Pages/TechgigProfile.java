package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseTest;

public class TechgigProfile extends BaseTest {

	@FindBy(xpath="//*[@id=\"advancedSearchBean\"]/div/div/p[1]/label[2]")
	WebElement techgigchkbox;
	
	@FindBy(xpath="/html/body/section/div/div/div[2]/div[1]/div/div/div[1]/a")
	WebElement chcknw;
	
	
	public TechgigProfile()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickItchkbox()
	{
		techgigchkbox.click();
		
	}
	
	public void checknow() 
	{
		chcknw.click();
	}
	
	
	
}
