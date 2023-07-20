package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class POM_Register 
{
	WebDriver driver;
	public POM_Register(WebDriver wd)
	{
		this.driver=wd;
	}
	
	By my_account = By.xpath("//span[normalize-space()='My Account']");
	By register = By.linkText("Register");
	By first_name = By.id("input-firstname");
	By last_name = By.id("input-lastname");
	By email = By.id("input-email");
	By telephone = By.id("input-telephone");
	By password = By.name("password");
	By cpassword = By.id("input-confirm");
	By  suscribe = By.xpath("//input[@value='0']");
	By checkbox = By.xpath("//input[@name='agree']");
	By contiue = By.xpath("//input[@value='Continue']");
	By successMsg = By.xpath("//h1[normalize-space()='Your Account Has Been Created!']");
	By againContinue = By.xpath("//a[@class='btn btn-primary']");
	By logout = By.linkText("Logout");
	
	public void clickOnAccount() 
	{
		driver.findElement(my_account).click();
	}
	
	public void clickOnRegister() 
	{
		driver.findElement(register).click();
	}
	
	public void enterFirstname(String fname) 
	{
		driver.findElement(first_name).sendKeys(fname);
	}
	
	public void enterLastname(String lname) 
	{
		driver.findElement(last_name).sendKeys(lname);
	}
	
	public void enterEmailid(String mail) 
	{
		driver.findElement(email).sendKeys(mail);
	}
	
	public void enterTelephone() 
	{
		driver.findElement(telephone).sendKeys("6565666");
	}
	public void enterPassword(String passwrd) 
	{
		driver.findElement(password).sendKeys(passwrd);
	}
	
	public void enterConfirmPassword(String pword) 
	{
		driver.findElement(cpassword).sendKeys(pword);
	}
	
	public void clickOnSuscribe() 
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", driver.findElement(suscribe));
	}
	
	public void clickOnCheckbox() 
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", driver.findElement(checkbox));
	}
	
	public void clickOnCountinueButton() 
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", driver.findElement(contiue));
		
	}
	
	public String getSuccessMessage() 
	{
		return driver.findElement(successMsg).getText();
	}
	
	public void clickAgain() 
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",driver.findElement(againContinue));
		
	}
	public void clickOnLogout() 
	{
		driver.findElement(my_account).click();
		driver.findElement(logout).click();
	}
}
