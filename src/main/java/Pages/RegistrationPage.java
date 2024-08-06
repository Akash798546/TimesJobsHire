package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseTest;

public class RegistrationPage extends BaseTest{
	
	@FindBy(xpath="//*[@id=\"login\"]/div[3]/a")
	WebElement registrationBtn;
	
	@FindBy(id="loginId")
	WebElement loginId;
	
	@FindBy(id="password")
	WebElement pswd;
	
	@FindBy(id="emailId")
	WebElement email;
	
	@FindBy(id="companyName")
	WebElement companyName;
	
	
	@FindBy(xpath="//*[@id=\"idIndustry\"]")
	WebElement industry;
	
	@FindBy(id="curLocation")
	WebElement currentLoc;
	
	@FindBy(id="address")
	WebElement add;
	
	
	
	
	
	public RegistrationPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	
	
}
