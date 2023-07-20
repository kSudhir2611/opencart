package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Helper.BaseClass;
import Utilities.POM_Login;

public class AddingProductToCart extends BaseClass
{
	@Test
	public void addTocart() 
	{
		POM_Login log_in = new POM_Login(wd);
		log_in.clickOnAccount();
		log_in.clickOnLogin();
		log_in.enterUsername("spedro@gmail.com");
		log_in.enterPassword("test@123");
		log_in.clickOnLoginbutton();
		wd.findElement(By.name("search")).sendKeys("mac");
		wd.findElement(By.xpath("//span//button[@type='button']")).click();
		
		wd.findElement(By.linkText("iMac")).click();
		
		WebElement quantity = wd.findElement(By.id("input-quantity"));
		quantity.clear();
		quantity.sendKeys("2");
		
		wd.findElement(By.id("button-cart")).click();
		
		String msg = wd.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
		System.out.println(msg);
	}
}
