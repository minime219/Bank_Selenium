package main.java.bank.testcases;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import main.java.bank.object.ExcelsFiles;
import main.java.bank.object.LogInPage;
import main.java.bank.object.ManagerPage;
import main.java.bank.object.Mapping;

public class TestCase2 extends TestCaseObject {
	
	ExcelsFiles excelFile; 
	
	@BeforeTest
	public void setUpBefore() {
		super.setUp(Mapping.LogInURL);
	}
	
	
	
	public void logIn(String username, String password) {
		//setUp();
		LogInPage page = PageFactory.initElements(driver, LogInPage.class);
		page.doLogIn(username, password);
		try {
			Alert alert = driver.switchTo().alert();
			Assert.assertEquals(alert.getText(), Mapping.LogInAlert);
			
		} catch (NoAlertPresentException Ex) {
			ManagerPage page1=PageFactory.initElements(driver, ManagerPage.class);
			Assert.assertEquals(page1.getManageWelcomeText(), Mapping.ManagerWelcome);
			
		}
		driver.quit();
		super.setUp(Mapping.LogInURL);
	}
	@Test
	public void verifiedLogin() throws IOException, InterruptedException {
	//	super.setUp(Mapping.LogInURL);
	//	LogInPage page = PageFactory.initElements(driver, LogInPage.class);
		excelFile = new ExcelsFiles();
		Sheet sheet = excelFile.readExcelFile(Mapping.ExcelFilePath, Mapping.ExcelFile, Mapping.SheetName);
		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		for (int i =1;i<rowCount;i++) {
	//		super.setUp(Mapping.LogInURL);
			Row row = sheet.getRow(i);
			logIn(row.getCell(0).toString(), row.getCell(1).toString());
			Thread.sleep(2000);
			
		//	driver.quit();
		}
	}
	
	@AfterTest
	public void tearDown() {
		super.tearDown(driver);
	}

}
