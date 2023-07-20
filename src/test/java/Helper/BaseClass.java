package Helper;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass 
{
	public static WebDriver wd;
	@Parameters({"brname"})
	
	@BeforeClass
	public void launchBrowser(@Optional("chrome")String browserName) 
	{
		if(browserName.equals("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			wd = new ChromeDriver();
		}
		else if(browserName.equals("edge")) 
		{
			WebDriverManager.edgedriver().setup();
			wd = new EdgeDriver();
		}
		wd.get("https://naveenautomationlabs.com/opencart/");
		
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@AfterClass
	public void closeBrowser() 
	{
		wd.quit();
	}
	
	public void captureScreeshot() throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot)wd;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String loc = System.getProperty("user.dir")+".//ScreenShot//screenshot"+dtm()+".png";
		File trg = new File(loc);
		FileUtils.copyFile(src, trg);
	}
	
	public String dtm() 
	{
		return new SimpleDateFormat("HH-mm-ss yyyy-MM-dd").format(new Date());
	}
}
