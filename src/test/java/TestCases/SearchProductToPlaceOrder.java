package TestCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Helper.BaseClass;
import Utilities.POM_Billing_Details;
import Utilities.POM_Login;

public class SearchProductToPlaceOrder extends BaseClass
{
	@Test
	public void placeOrder() 
	{
		//Login
		POM_Login log_in = new POM_Login(wd);
		log_in.clickOnAccount();
		log_in.clickOnLogin();
		log_in.enterUsername("spedro@gmail.com");
		log_in.enterPassword("test@123");
		log_in.clickOnLoginbutton();
		
		//Search Product
		wd.findElement(By.name("search")).sendKeys("MacBook");
		wd.findElement(By.xpath("//span//button[@type='button']")).click();
		wd.findElement(By.linkText("MacBook")).click();
		
		//Add to cart
		wd.findElement(By.id("button-cart")).click();
		
		String msg = wd.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
		System.out.println(msg);
		
		wd.findElement(By.xpath("//div[@id='cart']")).click();
		wd.findElement(By.xpath("//strong[normalize-space()='View Cart']")).click();
		
		//checkout
		wd.findElement(By.xpath("//div[@class='pull-right']//a")).click();
		
		//Billing details
		wd.findElement(By.xpath("//input[@value='new']")).click();
		POM_Billing_Details pbill_deatail = new POM_Billing_Details(wd);
		pbill_deatail.enterBillingDetails("sam", "pedro", "xys company", "gargoti", "Kolhapur", "145687");
		
		wd.findElement(By.xpath("//textarea[@name='comment']")).sendKeys("mac_book");
		
		wd.findElement(By.xpath("//input[@name='agree']")).click();
		wd.findElement(By.id("button-payment-method")).click();
		
		
		
		
	}
}
