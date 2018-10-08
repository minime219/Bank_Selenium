package main.java.bank.testcases.user;
import org.testng.annotations.*;

import main.java.bank.object.CustomizedStatementPage;
import main.java.bank.object.LogInPage;
import main.java.bank.object.ScreenshotTake;
import main.java.bank.object.user.pages.CustomerHomePage;
import main.java.bank.object.user.pages.FundTransferDetails;
import main.java.bank.object.user.pages.FundTransferPage;
import main.java.bank.testcases.TestCaseObject;
import main.java.bank.testcases.user.balance.Mapping;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
public class FundTransferAndStatement extends TestCaseObject {
	LogInPage logInPage;
	CustomerHomePage customerPage;
	FundTransferPage fundTransferPage;
	FundTransferDetails fundTransferDetails;
	ScreenshotTake scrShot;
	CustomizedStatementPage customisedPage;
	
	@BeforeTest
	public void init() {
		super.setUp(Mapping.LogInURL);
		logInPage = PageFactory.initElements(driver, LogInPage.class);
		customerPage = new CustomerHomePage(driver);
		fundTransferPage= new FundTransferPage(driver);
		fundTransferDetails= new FundTransferDetails(driver);
		customisedPage = PageFactory.initElements(driver, CustomizedStatementPage.class);
		scrShot = new ScreenshotTake(driver);
	}
	
	@AfterTest
	public void tearDown() {
		super.tearDown(driver);
	}
	
	@Test
	public void verifyFundTransfer() throws InterruptedException, IOException {
		logInPage.doLogIn(Mapping.User, Mapping.Password);
		Thread.sleep(2000);
		customerPage.fundTransferLinkClick();
		fundTransferPage.doFundTransfer(Mapping.AccID, Mapping.PayeeAcc, Mapping.Ammount, Mapping.Desc);
		Thread.sleep(2000);
		Assert.assertEquals(fundTransferDetails.getFromAcc(), Mapping.AccID);
		Assert.assertEquals(fundTransferDetails.getToAcc(), Mapping.PayeeAcc);
		scrShot.takesSnapshot(Mapping.ScreenshotFunTransferFilePath);
		//fundTransferDetails.continueClick();
	//	Thread.sleep(2000);
		
	}
	
	@Test(dependsOnMethods= {"verifyFundTransfer"})
	public void verifyRefreshingFundDetails() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(), Mapping.FundTransferURL);
		
	}
	
	@Test(dependsOnMethods= {"verifyRefreshingFundDetails"})
	public void verifyCustomizedStatement() throws InterruptedException, IOException {
		customerPage.customisedStatementClick();
		Thread.sleep(2000);
		customisedPage.doCustomized(Mapping.AccID);
		scrShot.takesSnapshot(Mapping.ScreenshotCustStatementFilePath);
		Thread.sleep(2000);
	}
	
	@Test(dependsOnMethods = {"verifyCustomizedStatement"})
	public void verifyTransferOnNotAuthorizationAcc() throws InterruptedException {
		customerPage.fundTransferLinkClick();
		Thread.sleep(2000);
		fundTransferPage.doFundTransfer(Mapping.PayeeAcc, Mapping.AccID, Mapping.Ammount, Mapping.Desc);
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), Mapping.NotAuthorizeAccount);
		alert.accept();
		Thread.sleep(2000);
	}
	
	@Test(dependsOnMethods = {"verifyTransferOnNotAuthorizationAcc"})
	public void verifyTransfertoNonExistAcc() throws InterruptedException {
		fundTransferPage.doFundTransfer(Mapping.AccID, Mapping.AccNotExist, Mapping.Ammount, Mapping.Desc);
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), Mapping.AccNotExistAlert);
		Thread.sleep(2000);
		alert.accept();
		Thread.sleep(2000);
	}
	
	@Test(dependsOnMethods= {"verifyTransfertoNonExistAcc"})
	public void verifyTransferToSameAcc() throws InterruptedException {
		fundTransferPage.doFundTransfer(Mapping.AccID, Mapping.AccID, Mapping.Ammount, Mapping.Desc);
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), Mapping.TransferSameAccAlert);
		alert.accept();
		Thread.sleep(2000);
	}
	
}
