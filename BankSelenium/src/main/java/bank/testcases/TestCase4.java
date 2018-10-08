package main.java.bank.testcases;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import main.java.bank.object.DataProviderClass;
import main.java.bank.object.LogInPage;
import main.java.bank.object.ManagerPage;
import main.java.bank.object.Mapping;
public class TestCase4 extends TestCaseObject {
	
	@BeforeMethod
	public void setUp() {
		super.setUp(Mapping.LogInURL);
	}
	
	@AfterMethod
	public void tearDown() {
		super.tearDown(driver);
	}
	

	
	@Test(dataProvider="LogInProvider", dataProviderClass=DataProviderClass.class)
	public void verifiedLogin(String username, String password) throws IOException {
	//	super.setUp(Mapping.LogInURL);
		LogInPage page = PageFactory.initElements(driver, LogInPage.class);
		page.doLogIn(username, password);
		
		try {
			Alert alert = driver.switchTo().alert();
			Assert.assertEquals(alert.getText(), Mapping.LogInAlert);
		} catch (NoAlertPresentException e) {
			// TODO: handle exception
			ManagerPage page1 = PageFactory.initElements(driver, ManagerPage.class);
			Assert.assertEquals(page1.getManageWelcomeText(), Mapping.ManagerWelcome);
			TakesScreenshot srcShot = (TakesScreenshot)driver;
			File srcFile= srcShot.getScreenshotAs(OutputType.FILE);
			Date date = new Date();
			
			File destFile = new File(Mapping.ScreenshotFilePath+date.toString().replaceAll(" ", "_").replaceAll(":", "-")+".png");
			FileUtils.copyFile(srcFile, destFile); 
		}
		
	//	driver.quit();
	//	super.setUp(Mapping.LogInURL);
		
	}

}
