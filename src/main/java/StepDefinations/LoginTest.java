package StepDefinations;

import java.time.Duration;

import org.apache.commons.mail.EmailException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Base.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.MeritPlusReport;
import Pages.PostJob;
import Pages.SendMassEmail;
import Pages.SendMassSms;
import Pages.ShortListing;
import Pages.TechgigProfile;
import Utils.CaptureScreenshot;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import junit.framework.Assert;

public class LoginTest extends BaseTest{
	
	LoginPage loginpage;
	HomePage homepage;
	LoginPage login;
	MeritPlusReport meritplus;
	TechgigProfile tgpro;
	SendMassSms sms;
	PostJob pj;
	SendMassEmail email;
   	ShortListing sl;
	@Before
	public void OpenBrowser()
	{
		BaseTest.inItBrowser();
	}
	
	@After
	public void tearDown(Scenario scenario) throws EmailException {
        if (scenario.isFailed()) {
            String screenshotPath = CaptureScreenshot.captureScreenshot(driver, scenario.getName());
            // Attach the screenshot to the scenario
            scenario.attach(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png", scenario.getName());
        }
//       EmailUtil.sendEmail();
        driver.quit();
    }
	
	
//*************************************Application Landing Page verification****************************************	
	@Given("User is on Application page")
	public void getLandingPage()
	{
		String url=prop.getProperty("ApplicationURL");
		driver.get(url);
		loginpage=new LoginPage();
		
	}
    @Then("Verify user is on Application Page")
    public void verifyLandinPage()
    {
     String ExpectedTitle="Employer : Login Page";
     Assert.assertEquals(ExpectedTitle, loginpage.getTitle());
    }
    
   
    //**********************************Login Verification*************************************************************
    @Given("login on Application")
    public void loginOnApplicattion()
    {
    	login = new LoginPage();
    	homepage=login.doLogin();
    }
    
    @Then("verify that user is successfully logged in")
    public void verifyLoggedIn()
    {
//    	try {
//    	String ExpTitle="Session";
//    	System.out.println(loginpage.getTitle());
//    	Assert.assertEquals(ExpTitle, loginpage.getTitle());
//    	}
//    	catch(Exception e)
//    	{
//    		String ExpTl="Session";
//    		Assert.assertEquals(ExpTl, loginpage.getTitle());
//    	}
    	String ExpTitle="Session";
    	if (ExpTitle.equalsIgnoreCase(login.getTitle()))
    	{
    		
    		Assert.assertEquals(ExpTitle, login.getTitle());
    	}
    	else
    	{
    		String ExpTl="Dashboard | TimesJobs Employer - Online Recruitment Solution from TimesJobs.com";
    		Assert.assertEquals(ExpTl, login.getTitle());
    	}
    }

    
    //********************************Search Candidate and Resume Download*******************************************
    
    
    @Given("click on QuickSearchButton")
    public void clickQuckSrch() throws InterruptedException
    {  
    	login=new LoginPage();
    	homepage=login.doLogin();
    	homepage.clickOnQuickSerach();
    }
    @Then("Enter Skills to search")
    public void enterText() throws InterruptedException
    {
    	homepage.sendSearchText();
    }
    
    @Then("click on SearchReseumeBtn")
    public void srchrsmbtn() throws InterruptedException
    {
    	homepage.clickOnSearchResumeBTn();
    }

    @Then("Click on Candidate Title")
    public void clickcandTitle()
    {
    	homepage.ClickOnTitle();
    	BaseTest.SwitchToNewWindow();
    	
    }
    
    @Then("Click on Download Button")
    public void ClickInDownloadResume() throws InterruptedException
    {
//    	Thread.sleep(Duration.ofSeconds(4));
    	homepage.ClickOnDownload();
    	BaseTest.SwitchToOriginalWindow();
    	
    	
    }
    
    
    //********************************************Merit Plus Report View***********************************
    
    
    @Given("user is on search Result page")
    public void searchSkill() throws InterruptedException
    {
    	login=new LoginPage();
    	homepage=login.doLogin();
    	homepage.clickOnQuickSerach();
    	homepage.sendSearchText();
    	homepage.clickOnSearchResumeBTn();
    	meritplus=new MeritPlusReport();
    }
    
    @Then("Select all resumes from the Recency")
    public void selectAllResumes() throws InterruptedException
    {
       meritplus.slctAllRsms();
//       Thread.sleep(Duration.ofSeconds(2));
    }
    
    
    @Then("Refine on Non-IT Skill Quotient filter")
    public void refineNOnItFiler()
    {
    	meritplus.meritPluschkbox();
    	meritplus.refinebtn();
    	
    }
    
    @Then("click on candidate Title")
    public void candidateTitleClick()
    {
    	homepage.ClickOnTitle();
    	BaseTest.SwitchToNewWindow();
    }
    
    
    @Then("click on meritplus report button")
    public void meritplusReport() throws InterruptedException
    {
    	meritplus.viewReport();
    }
    
    @Then("Refine on IT Skill Quotient filter")
    public void ItFilter()
    {
    	 tgpro=new TechgigProfile();
    	 tgpro.clickItchkbox();
    	 meritplus.refinebtn();
    }
    @Then("click on check now button")
    public void checkNowButton() throws InterruptedException

    {
    	tgpro.checknow();
//    	Thread.sleep(2000);
    }
    
    @Given("user is on search Result page by searching email")
    public void searchEmail() throws InterruptedException
    {
    	login=new LoginPage();
    	homepage=login.doLogin();
    	homepage.clickOnQuickSerach();
    	homepage.EmailSearchText();
    	homepage.clickOnSearchResumeBTn();
    	 sms=new SendMassSms();
    	 
    	 
    }
    
    @Then("Click on user's checkbox")
    public void chkbxClick()
    {
    	
    	sms.chkboxbtn();
    	
    }
    @Then("Click on the Send Job As sms") 
    public void sndJob() throws InterruptedException
    {
    	sms.sendJobAsSms();
//    	Thread.sleep(Duration.ofSeconds(2));
    }
    @Then("Select the particular job to send")
    public void selectJob() throws InterruptedException
    {
    	sms.chooseJob();
//    	Thread.sleep(Duration.ofSeconds(2));
    }
    
    @Then("Select the Template")
    public void selectTemp() throws InterruptedException
    {
    	sms.templateRadio();
    }
    @Then("click on now radio button")
    public void rdiobtn()
    {
    	sms.nowRadioBtn();
    }
    @Then("Click on Send Sms button")
    public void submitButton() throws InterruptedException
    {
    	sms.clickOnSbmtBtn();
    }
    
    @Then("Verify that sms is successfully sent")
    public void verifySms()
    {
    	String msg="1 SMS are successfully delivered.\r\n"
    			+ "\r\n"
    			+ "Note: SMS will not be delivered to DND/ International/ Landline/ Invalid numbers.\r\n"
    			+ "For undelivered SMS, points will be credited back to your account within 48 hours.";
    	sms.verifyingSmsSuccessfully(msg);
    }
    
    @Given("user is on dashboard page.")
    public void dashboardPage()
    {

    	login=new LoginPage();
    	homepage=login.doLogin();
    }
    
    @Then("user clicked on post a job") 
    public void postJob()
    {
    	 pj=new PostJob();
    	 pj.clickonPostjobbtn();
    }
    
    @Then("Click on Send Email button")
    public void cliclOnSendEmailBtn()
    {
    	email=new SendMassEmail();
    	email.clicksendemail();
    	
    }
    @Then("select the job designation")
    public void designation() throws InterruptedException
    {
    	email.setDesignation();
    }
    
    @Then("Select the Minimuma and Maximum experience")
    public void setExperience() throws InterruptedException
    {
    	email.setExp();
    }
    
    @Then("Select the job location")
    public void selectLocation() throws InterruptedException
    {
    	email.selectCity();
    }
  
    
    @Then("Select the template")
    public void template()
    {
    	email.selectTemp();
    }
    
    @Then("Enter the Email Id")
    public void setEmailId()
    {
    	email.setEmail();
    }

    @Then("Click on candidate can reply checkbox.")
    public void setChkFlag() throws InterruptedException
    {
    	email.checkFlag();
    }
  
    @Then("Click on send button")
    public void clickOnSubBtn()
    {
    	email.clickSubmit();
    }
    
    
    @Then("verify that email is successfully send.")
    public void verifyEmailMsg()
    {
    	String successmsg="Your email/job has been successfully sent to 2 candidates.";
    	email.verifyEmail(successmsg);
    }
    
    @Then("select candidates checkbox randomly")
    public void selectCandidatesCheckBox() throws InterruptedException
    {
          sl=new ShortListing();
          sl.selectChk();
    }

    @Then("Click on shortlist button")
    public void clickOnShortListBtn()
    {
    	sl.clickSortlist();
    }
    
    @Then("Create a folder with name as current date")
    public void createFolderName() throws InterruptedException
    {
    	sl.createfolder();
    }

    @Then("verify that folder is created successfully")
    public void verifyFolder()
    {
    	sl.verifyfolder();
    }
}
