package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseTest;

public class LoginPage extends BaseTest{
	
	
	
	@FindBy(id="j_username")
	WebElement UserName;
	
	
	@FindBy(id="j_password")
	WebElement Password;
	
	@FindBy(id="button")
	WebElement button;
	
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	

	


	public String getTitle()
	{
		return driver.getTitle();
	}
	
//	public void setUserName()
//	{
//	 UserName.sendKeys(prop.getProperty("username"));	
//	}
//	
//	public void setPassword()
//	{
//		Password.sendKeys("Password");
//	}
//	
//	public void ClickOnSubmit()
//	{
//		button.click();
//	}
	
	public HomePage doLogin()
	{
		
		
		this.UserName.sendKeys(prop.getProperty("username"));
		this.Password.sendKeys(prop.getProperty("Password"));
		this.button.click();
		
		return new HomePage();
	}
	}
