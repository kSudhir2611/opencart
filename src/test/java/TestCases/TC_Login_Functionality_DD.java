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
import Utilities.POM_Login;

public class TC_Login_Functionality_DD extends BaseClass
{
    @Test(dataProvider="input")
	public void dataDrivenTesting(String uname,String pword) throws IOException, InterruptedException 
	{
		POM_Login log_in = new POM_Login(wd);
		
		log_in.clickOnAccount();
		log_in.clickOnLogin();
		log_in.enterUsername(uname);
		log_in.enterPassword(pword);
		Thread.sleep(3000);
		log_in.clickOnLoginbutton();
		
		String actual = "My Account";
		if(actual.equals(wd.getTitle()))
			System.out.println("Login is successful");
		else {
			System.out.println("Login unseccessful");
			captureScreeshot();
		}
		
		log_in.clickOnAccount();
		Thread.sleep(3000);
		log_in.clickOnLogout();
	}
	
	@DataProvider(name="input")
	public String[][] dataGeneratemethod() throws IOException 
	{
		String location = System.getProperty("user.dir")+".//Data//Register.xlsx";
		File file = new File(location);
		
		FileInputStream fis = new FileInputStream(file);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = wb.getSheet("sheet2");
		
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
