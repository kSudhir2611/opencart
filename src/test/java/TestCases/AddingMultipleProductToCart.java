package TestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Helper.BaseClass;
import Utilities.POM_Login;

public class AddingMultipleProductToCart extends BaseClass
{
	@Test
	public void addingMultipleProductTocart() 
	{
		//Login
		POM_Login log_in = new POM_Login(wd);
		log_in.clickOnAccount();
		log_in.clickOnLogin();
		log_in.enterUsername("spedro@gmail.com");
		log_in.enterPassword("test@123");
		log_in.clickOnLoginbutton();
		
		wd.findElement(By.xpath("//img[@title='naveenopencart']")).click();
		
		String[] productList = {"MacBook","iPhone"};
		
		for(int i=0;i<productList.length;i++) 
		{
		
			wd.findElement(By.linkText(productList[i])).click();
			wd.findElement(By.id("button-cart")).click();
			
			String msg = wd.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
			System.out.println(msg);
			wd.findElement(By.xpath("//img[@title='naveenopencart']")).click();
		}
	}
}
