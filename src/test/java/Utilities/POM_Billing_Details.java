package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class POM_Billing_Details 
{
	WebDriver wd;
	
	public POM_Billing_Details(WebDriver wd) 
	{
		this.wd=wd;
	}
	
	By firstname = By.id("input-payment-firstname");
	By lastname = By.id("input-payment-lastname");
	By company = By.id("input-payment-company");
	By address1 = By.id("input-payment-address-1");
	By city = By.id("input-payment-city");
	By post_code = By.id("input-payment-postcode");
	By country = By.id("input-payment-country");
	By zone = By.id("input-payment-zone");
	By continu = By.xpath("//input[@id='button-payment-address']");
	
	public void enterBillingDetails(String name,String lname,String cmpany,String adrs,String cty,String postcode)
	{
		wd.findElement(firstname).sendKeys(name);
		wd.findElement(lastname).sendKeys(lname);
		wd.findElement(company).sendKeys(cmpany);
		wd.findElement(address1).sendKeys(adrs);
		wd.findElement(city).sendKeys(cty);
		wd.findElement(post_code).sendKeys(postcode);
		 
		Select cntry = new Select(wd.findElement(country));
		cntry.selectByVisibleText("India");
		
		Select state = new Select(wd.findElement(zone));
		state.selectByVisibleText("Maharashtra");
		
		wd.findElement(continu).click();
	} 
	
}
