package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BaseTest;

public class HomePage extends BaseTest{
	

	
	@FindBy(linkText="Quick Search")
	WebElement QuickSearch;
	
	@FindBy(xpath="//b[contains(text(), 'Reset the Account')]")
	WebElement reset;
	
	@FindBy(xpath="//a[@class='submenu' and contains(text(),'Search Candidates')]")
	WebElement searchHover;
	
	@FindBy(xpath="//ul[@class='token-input-list-facebook' and @id='KeywordLeastSuggList_token']/li[@class='token-input-input-token-facebook']/input[@id='token-input-txtKeywordLeast']")
	WebElement searchValue;
	
	@FindBy(xpath="/html/body/header/div/div[2]/div/div[1]/div[2]")
	WebElement hamburger;
	
	@FindBy(xpath="//*[@id=\"advancedSearchBean\"]/div/div/div[6]/input")
	WebElement searchResumebtn;
	
	@FindBy(xpath="//*[@id=\"mid\"]/div[2]/div[1]/label/span/a/span")
	WebElement CandidateTitle;
	
	@FindBy(xpath="/html/body/header/div/div[2]/div[1]/div/div[2]/a[1]/span/label/i")
	WebElement resume;
	

	WebDriverWait wait;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnQuickSerach() throws InterruptedException
	{
		try
		{
			reset.click();
//			hamburger.click();
			
			
	        Actions actions = new Actions(driver);

	        // Perform the hover action
	        actions.moveToElement(searchHover).perform();
	        
	        QuickSearch.click();

//	    
		}
		catch(Exception e)
		{
			
			Actions actions = new Actions(driver);

	        // Perform the hover action
	        actions.moveToElement(searchHover).perform();
	        
	        QuickSearch.click();

		} 
		        
		}
		
	
	
	public void sendSearchText() 
	{
		searchValue.sendKeys(prop.getProperty("SkillsToSearch"));
		
	}
	
	public void EmailSearchText() 
	{
		searchValue.sendKeys(prop.getProperty("EmailIdSearch"));
		
	}
	
	public void clickOnSearchResumeBTn() throws InterruptedException
	{
		searchResumebtn.click();
		Thread.sleep(4000);
	}
	
	public void ClickOnTitle()
	{
		CandidateTitle.click();
	}
	
	public void ClickOnDownload()
	{
		resume.click();
	}
	

}
