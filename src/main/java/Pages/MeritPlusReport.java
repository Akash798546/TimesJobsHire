package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.BaseTest;

public class MeritPlusReport extends BaseTest {

	
	@FindBy(xpath="//*[@id=\"advancedSearchBean\"]/div/div/p[2]/label[2]")
	WebElement meritplusfilter;
	
	@FindBy(xpath="//*[@id=\"button\"]")
	WebElement refine;
	
	@FindBy(xpath="/html/body/section/div/div/div[2]/div/div[1]/div[1]/div[2]/div/a")
	WebElement viewreport;
	
	@FindBy(id="monthsOld")
	WebElement allResumes;
	
	public MeritPlusReport()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void meritPluschkbox()
	{
		meritplusfilter.click();
	}
	
	public void slctAllRsms()
	{ 
		System.out.println(allResumes.getText());
		
		Select select =new Select(allResumes);
		List<WebElement> allOptions = select.getOptions();
		System.out.println(allOptions);
        select.selectByVisibleText("All Resumes");
		
		
		
	}
	public void refinebtn()
	{
		refine.click();
	}
	
	public void  viewReport() throws InterruptedException
	{
		viewreport.click();
		Thread.sleep(3000);
	}
}
