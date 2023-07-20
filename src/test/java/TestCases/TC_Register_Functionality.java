package TestCases;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Helper.BaseClass;
import Utilities.POM_Register;

public class TC_Register_Functionality extends BaseClass
{
	
	@Parameters({"fname","lname","email","password"})
	@Test
	public void registerUser(String name,String lname,String mail,String pword) throws IOException, InterruptedException 
	{
		POM_Register pom_reg = new POM_Register(wd);
		pom_reg.clickOnAccount();
		pom_reg.clickOnRegister();
		pom_reg.enterFirstname(name);
		pom_reg.enterLastname(lname);
		pom_reg.enterEmailid(mail);
		pom_reg.enterTelephone();
		pom_reg.enterPassword(pword);
		pom_reg.enterConfirmPassword(pword);
		pom_reg.clickOnSuscribe();
		pom_reg.clickOnCheckbox();
		Thread.sleep(5000);
		pom_reg.clickOnCountinueButton();
		
		
		String successMessage = pom_reg.getSuccessMessage();
		if(successMessage.equals("Your Account Has Been Created!")) 
		{
			System.out.println("user registered successfully");
		}
		else 
		{
			captureScreeshot();
		}
		
		pom_reg.clickAgain();
		String pageTitle = wd.getTitle();
		
		if(pageTitle.equals("My Account")) 
		{
			System.out.println("Test case is passed");
		}
		else 
		{
			System.out.println("Test case is failed");
		}
		
		pom_reg.clickOnLogout();
	}
}
