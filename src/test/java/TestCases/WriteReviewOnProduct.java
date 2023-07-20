package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Helper.BaseClass;

public class WriteReviewOnProduct extends BaseClass
{
	@Test(priority=1)
	public void writeReviewLessthan25Character() 
	{
		wd.findElement(By.name("search")).sendKeys("MacBook");
		wd.findElement(By.xpath("//span[@class='input-group-btn']")).click();
		wd.findElement(By.linkText("MacBook")).click();
		
		wd.findElement(By.xpath("//li//a[@href='#tab-review']")).click();
		
		wd.findElement(By.xpath("//input[@id='input-name']")).sendKeys("Sam Pedro");
		wd.findElement(By.xpath("//textarea[@name='text']")).sendKeys("good product");
		wd.findElement(By.xpath("//input[@value='4']")).click();
		wd.findElement(By.xpath("//button[@id='button-review']")).click();
		
		String warning_msg = wd.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		System.out.println(warning_msg);
	}
	
	@Test(priority=2)
	public void writeReviewMorethan25Character() 
	{
		WebElement searchfield =  wd.findElement(By.name("search"));
		searchfield.clear();
		searchfield.sendKeys("MacBook");
		wd.findElement(By.xpath("//span[@class='input-group-btn']")).click();
		wd.findElement(By.linkText("MacBook")).click();
		
		wd.findElement(By.xpath("//li//a[@href='#tab-review']")).click();
		
		wd.findElement(By.xpath("//input[@id='input-name']")).sendKeys("Sam Pedro");
		wd.findElement(By.xpath("//textarea[@name='text']")).sendKeys("This product has good configuration and is easy to use");
		wd.findElement(By.xpath("//input[@value='4']")).click();
		wd.findElement(By.xpath("//button[@id='button-review']")).click();
		
		String warning_msg = wd.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
		System.out.println(warning_msg);
	}
}
