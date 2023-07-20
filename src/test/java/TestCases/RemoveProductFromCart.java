package TestCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Helper.BaseClass;

//Pre-requisite-->Product must me added to cart
public class RemoveProductFromCart extends BaseClass
{
	@Test
	public void removeProductFromCart() 
	{
		AddingMultipleProductToCart ampc = new AddingMultipleProductToCart();
		ampc.addingMultipleProductTocart();
		
		wd.findElement(By.xpath("//div[@id='cart']")).click();
		wd.findElement(By.xpath("//strong[normalize-space()='View Cart']")).click();
		wd.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr[1]/td[4]/div/span/button[2]")).click();
		wd.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr[2]/td[4]/div/span/button[2]")).click();
		
		String msg = wd.findElement(By.xpath("//*[@id=\"content\"]/p")).getText();
		
		System.out.println(msg);
		
		wd.findElement(By.linkText("Continue")).click();
	}
	
}
