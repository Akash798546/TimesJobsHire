package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseTest;


public class PostJob extends BaseTest{
	
	@FindBy(xpath="//a[@class='submenu' and contains(text(),'WizJobs')]")
	WebElement wizjob;
	
	@FindBy(linkText="Post a WizJob")
	WebElement postjob;
	
	@FindBy(xpath="//b[contains(text(), 'Reset the Account')]")
	WebElement reset;
	
	public PostJob()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickonPostjobbtn()
	{
		  
	        
	        try
			{
				reset.click();
//				hamburger.click();
				
				
		        Actions actions = new Actions(driver);

		        // Perform the hover action
		        actions.moveToElement(wizjob).perform();
		        
		        postjob.click();

//		    
			}
			catch(Exception e)
			{
				
				Actions actions = new Actions(driver);

		        // Perform the hover action
		        actions.moveToElement(wizjob).perform();
		        
		        postjob.click();

			} 
			     
	        
		
	}

}
