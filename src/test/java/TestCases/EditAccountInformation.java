package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Helper.BaseClass;
import Utilities.POM_Address;
import Utilities.POM_Billing_Details;
import Utilities.POM_Login;

public class EditAccountInformation extends BaseClass
{
	@Test
	public void editAccountInfo() 
	{
		//edit account info
		POM_Login log_in = new POM_Login(wd);
		log_in.clickOnAccount();
		log_in.clickOnLogin();
		log_in.enterUsername("spedro@gmail.com");
		log_in.enterPassword("sam@123");
		log_in.clickOnLoginbutton();
		
		wd.findElement(By.linkText("Edit your account information")).click();
		WebElement telephone=wd.findElement(By.name("telephone"));
		telephone.clear();
		telephone.sendKeys("8898985856");
		wd.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String successMsg=wd.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
		System.out.println(successMsg);
		
		//change password
		wd.findElement(By.linkText("Change your password")).click();
		wd.findElement(By.id("input-password")).sendKeys("sam@123");
		wd.findElement(By.id("input-confirm")).sendKeys("sam@123");
		
		wd.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String successMessage=wd.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
		System.out.println(successMessage);
		
		
		//add adress
		wd.findElement(By.linkText("Modify your address book entries")).click();
		wd.findElement(By.linkText("New Address")).click();
		
		POM_Address pom_add = new POM_Address(wd);
		pom_add.enterBillingDetails("sam", "pedro", "vegam", "123 avenue", "Patna", "454687");
		wd.findElement(By.xpath("//input[@value='0']")).click();
		
		wd.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String successMessage1=wd.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
		System.out.println(successMessage1);
		
		POM_Login pom_log = new POM_Login(wd);
		pom_log.clickOnAccount();
		pom_log.clickOnLogout();
	}
}

