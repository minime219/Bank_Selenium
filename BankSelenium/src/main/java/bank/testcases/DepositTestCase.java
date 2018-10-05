package main.java.bank.testcases;
import org.testng.annotations.*;

import main.java.bank.object.DepositDetailsPage;
import main.java.bank.object.DepositPage;
import main.java.bank.object.LogInPage;
import main.java.bank.object.ManagerPage;
import main.java.bank.object.Mapping;
import main.java.bank.object.ScreenshotTake;

import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;

public class DepositTestCase extends TestCaseObject {
	
	LogInPage loginPage;
	ManagerPage managerPage;
	DepositPage depositPage;
	DepositDetailsPage depositDetailsPage;
	ScreenshotTake screenShot;
	
	@BeforeTest
	public void init() {
		super.setUp(Mapping.LogInURL);
		loginPage = PageFactory.initElements(driver, LogInPage.class);
		managerPage = PageFactory.initElements(driver, ManagerPage.class);
		depositPage = PageFactory.initElements(driver, DepositPage.class);
		depositDetailsPage = PageFactory.initElements(driver, DepositDetailsPage.class);
		screenShot = new ScreenshotTake(driver);
	}
	
	@AfterTest
	public void tearDown() {
		super.tearDown(driver);
	}
	
	@Test
	public void verifyDepositMade() throws InterruptedException, IOException {
		loginPage.doLogIn(Mapping.User, Mapping.NewPassword);
		Thread.sleep(2000);
		Assert.assertEquals(managerPage.getManageWelcomeText(), Mapping.ManagerWelcome);
		managerPage.depositClick();
		Thread.sleep(2000);
		Assert.assertEquals(depositPage.getHeader(), Mapping.DepositPageHeader);
		depositPage.doDeposit(Mapping.AccID_2, Mapping.FundTransferAmount, Mapping.FundTransferDesc);
		Thread.sleep(2000);
		Assert.assertEquals(depositDetailsPage.getHeader(), Mapping.DepositDetailsPageHeader+Mapping.AccID_2);
		Map<String,String> map = new HashMap<String,String>();
		map = depositDetailsPage.getDepositDetails();
		Assert.assertEquals(map.get("AccountID"), Mapping.AccID_2);
		Assert.assertEquals(map.get("Ammount"), Mapping.FundTransferAmount);
		Assert.assertEquals(map.get("Desc"), Mapping.FundTransferDesc);

		screenShot.takesSnapshot(Mapping.ScreenshotFilePath);
		Thread.sleep(2000);
		System.out.println(driver.getCurrentUrl());
		}
	
	@Test(dependsOnMethods= {"verifyDepositMade"})
	public void verifyDepositRedirect() {
		driver.navigate().refresh();
		Assert.assertEquals(depositPage.getHeader(), Mapping.DepositPageHeader);
		System.out.println(driver.getCurrentUrl());
	}
}
