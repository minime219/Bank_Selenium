package main.java.bank.testcases.user.balance;
import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import main.java.bank.object.LogInPage;
import main.java.bank.object.ScreenshotTake;
import main.java.bank.object.user.pages.BalanceDetailsPage;
import main.java.bank.object.user.pages.BalanceEnquiryPage;
import main.java.bank.object.user.pages.CustomerHomePage;
import main.java.bank.testcases.TestCaseObject;

public class BalanceEnquiry extends TestCaseObject {
	
	LogInPage logInPage;
	CustomerHomePage customerPage;
	BalanceEnquiryPage balanceEnquiryPage;
	BalanceDetailsPage balanceDetailsPage;
	ScreenshotTake scrShot;
	
	@BeforeTest
	public void init() {
		super.setUp(Mapping.LogInURL);
		logInPage = PageFactory.initElements(driver, LogInPage.class);
		customerPage = new CustomerHomePage(driver);
		balanceEnquiryPage = new BalanceEnquiryPage(driver);
		balanceDetailsPage = new BalanceDetailsPage(driver);
		scrShot = new ScreenshotTake(driver);
	}
	
	@AfterTest
	public void tearDown() {
		super.tearDown(driver);
	}
	
	@Test
	public void balanceEnquiry() throws InterruptedException, IOException {
		logInPage.doLogIn(Mapping.User, Mapping.Password);
		Thread.sleep(2000);
		customerPage.balanceEnquiryClick();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(), Mapping.BalanceEnquiryURL);
		balanceEnquiryPage.doEnquiry(Mapping.AccID);
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(), Mapping.BalanceDetailsURL);
		Assert.assertEquals(balanceDetailsPage.getHeader(), Mapping.BalanceDetailsHeader+Mapping.AccID);
		Assert.assertEquals(balanceDetailsPage.getAccNo(), Mapping.AccID);
		scrShot.takesSnapshot(Mapping.ScreenshotFilePath);
		
	}
}
