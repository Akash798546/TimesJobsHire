package testng;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class AnnotionsCheck {
	
	
	@BeforeSuite
	public void BeforeSuiteChk()
	{
		
		
		System.out.println("This is the Before suite check");
	}
	
	
	@AfterSuite
	public void AfterSuiteChk()
	{
		
		
		System.out.println("This is the After suite check");
	}
	
	

}
