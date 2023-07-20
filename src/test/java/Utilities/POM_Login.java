package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM_Login 
{
    WebDriver wd;
	public POM_Login(WebDriver driver) 
	{
		this.wd=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement my_acc;
	
	@FindBy(linkText="Login")
	WebElement login;
	
	@FindBy(id="input-email")
	WebElement emailid;
	
	@FindBy(id="input-password")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement login_button;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']")
	WebElement logout;
	public void clickOnAccount() 
	{
		my_acc.click();
	}
	
	public void clickOnLogin() 
	{
		login.click();
	}
	
	public void enterUsername(String uname) 
	{
		emailid.sendKeys(uname);
	}
	
	public void enterPassword(String pword) 
	{
		password.sendKeys(pword);
	}
	
	public void clickOnLoginbutton() 
	{
		login_button.click();
	}
	
	public void clickOnLogout() 
	{
		logout.click();
	}
}
