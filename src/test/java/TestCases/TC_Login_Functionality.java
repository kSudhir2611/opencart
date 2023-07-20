package TestCases;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Helper.BaseClass;
import Utilities.POM_Login;

public class TC_Login_Functionality extends BaseClass
{
	@Parameters({"name","password"})
	@Test
	public void login(String uname,String pword) throws IOException, InterruptedException 
	{
		POM_Login log_in = new POM_Login(wd);
		
		log_in.clickOnAccount();
		log_in.clickOnLogin();
		log_in.enterUsername(uname);
		log_in.enterPassword(pword);
		log_in.clickOnLoginbutton();
		
		String actual = "My Account";
		if(actual.equals(wd.getTitle()))
			System.out.println("Login is successful");
		else {
			System.out.println("Login unseccessful");
			captureScreeshot();
		}
		
		log_in.clickOnAccount();
		Thread.sleep(3000);
		log_in.clickOnLogout();
	}
	
}
