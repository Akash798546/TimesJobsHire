package Utils;

import Base.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;

public class CommonSteps extends BaseTest {
	
	static LoginPage loginpage;
	static HomePage homepage;
	
	public static void loginOnApplication() {
		String url=prop.getProperty("ApplicationURL");
		driver.get(url);
		loginpage=new LoginPage();
		homepage=new HomePage();
		homepage=loginpage.doLogin();
    }
        
    

}
