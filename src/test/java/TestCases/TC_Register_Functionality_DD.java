package TestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Helper.BaseClass;
import Utilities.POM_Register;

public class TC_Register_Functionality_DD extends BaseClass
{
	@Test(dataProvider="data")
	public void dataDrivenTesting(String name,String lname,String mail,String pword) throws InterruptedException, IOException 
	{
		POM_Register pom_reg = new POM_Register(wd);
		pom_reg.clickOnAccount();
		pom_reg.clickOnRegister();
		pom_reg.enterFirstname(name);
		pom_reg.enterLastname(lname);
		pom_reg.enterEmailid(mail);
		pom_reg.enterTelephone();
		pom_reg.enterPassword(pword);
		pom_reg.enterConfirmPassword(pword);
		pom_reg.clickOnSuscribe();
		pom_reg.clickOnCheckbox();
		Thread.sleep(5000);
		pom_reg.clickOnCountinueButton();
		
		String successMessage = pom_reg.getSuccessMessage();
		if(successMessage.equals("Your Account Has Been Created!")) 
		{
			System.out.println("user registered successfully");
		}
		else 
		{
			captureScreeshot();
		}
		
		pom_reg.clickAgain();
		String pageTitle = wd.getTitle();
		
		if(pageTitle.equals("My Account")) 
		{
			System.out.println("Test case is passed");
		}
		else 
		{
			System.out.println("Test case is failed");
		}
		
		pom_reg.clickOnLogout();
	}
	
	
	@DataProvider(name="data")
	public String[][] dataProviderMethod() throws IOException 
	{
		String location = System.getProperty("user.dir")+".//Data//Register.xlsx";
		File file = new File(location);
		
		FileInputStream fis = new FileInputStream(file);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = wb.getSheet("sheet1");
		
		int rowCount = sheet.getPhysicalNumberOfRows();
		int ColCount = sheet.getRow(0).getLastCellNum();
		
		String[][] data = new String[rowCount-1][ColCount];
		
		for(int i=0;i<rowCount-1;i++) 
		{
			XSSFRow row=sheet.getRow(i+1);
			for(int j=0;j<ColCount;j++) 
			{
				XSSFCell cell=row.getCell(j);
				
				CellType celltype = cell.getCellType();
				
				switch(celltype) 
				{
				case STRING:
					data[i][j]=cell.getStringCellValue();
					break;
					
				case NUMERIC:
					data[i][j]=String.valueOf(cell.getNumericCellValue());
				}
			}
		}
		return data;
		
	}
}
