package main.java.bank.testcases;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import org.testng.Assert;

import main.java.bank.object.BalanceDetailsPage;
import main.java.bank.object.BalanceEnquiryPage;
import main.java.bank.object.CustomizedStatementPage;
import main.java.bank.object.LogInPage;
import main.java.bank.object.ManagerPage;
import main.java.bank.object.Mapping;
import main.java.bank.object.MiniStatementPage;
import main.java.bank.object.MiniTransactionDetailsPage;
import main.java.bank.object.ScreenshotTake;
import main.java.bank.object.TransactionsDetails;
import main.java.bank.object.WithdrawalDetailsPage;
import main.java.bank.object.WithdrawalPage;

public class WithdrawalTestCase extends TestCaseObject {
	
	LogInPage loginPage;
	ManagerPage managerPage;
	WithdrawalPage withdrawalPage;
	WithdrawalDetailsPage withdrawalDetails;
	ScreenshotTake scrshot;
	MiniStatementPage miniStatement;
	MiniTransactionDetailsPage miniDetails;
	BalanceEnquiryPage balanceEnquiry;
	BalanceDetailsPage balanceDetails;
	CustomizedStatementPage customizedStatementPage;
	TransactionsDetails transactionDetails;
	Map<String,String> map;
	Map<String,String> map1;
	
	@BeforeTest
	public void init() {
		super.setUp(Mapping.LogInURL);
		loginPage = PageFactory.initElements(driver, LogInPage.class);
		managerPage = PageFactory.initElements(driver, ManagerPage.class);
		withdrawalPage = PageFactory.initElements(driver, WithdrawalPage.class);
		withdrawalDetails = PageFactory.initElements(driver, WithdrawalDetailsPage.class);
		miniStatement = PageFactory.initElements(driver, MiniStatementPage.class);
		miniDetails = PageFactory.initElements(driver, MiniTransactionDetailsPage.class);
		balanceEnquiry = PageFactory.initElements(driver, BalanceEnquiryPage.class);
		balanceDetails = PageFactory.initElements(driver, BalanceDetailsPage.class);
		customizedStatementPage = PageFactory.initElements(driver, CustomizedStatementPage.class);
		transactionDetails = new TransactionsDetails(driver);
		scrshot = new ScreenshotTake(driver);
	}
	
	@AfterTest
	public void tearDown() {
		super.tearDown(driver);
	}
	
	@Test
	public void verifyWithdrawal() throws InterruptedException, IOException {
		loginPage.doLogIn(Mapping.User, Mapping.NewPassword);
		Thread.sleep(2000);
		Assert.assertEquals(managerPage.getManageWelcomeText(), Mapping.ManagerWelcome);
		managerPage.withdrawalLinkClick();
		Thread.sleep(2000);
		Assert.assertEquals(withdrawalPage.getHeader(), Mapping.WithdrawalPageHeader);
		withdrawalPage.doWithdrawal(Mapping.AccID_2, Mapping.FundTransferAmount, Mapping.FundTransferDesc);
		Thread.sleep(2000);
		Assert.assertEquals(withdrawalDetails.getHeader(), Mapping.WithdrawalDetailsHeader+Mapping.AccID_2);
		map = withdrawalDetails.getWithdrawalDetails();
		Assert.assertEquals(map.get("AccountID"), Mapping.AccID_2);
		Assert.assertEquals(map.get("Ammount"), Mapping.FundTransferAmount);
		Assert.assertEquals(map.get("Desc"), Mapping.FundTransferDesc);
		scrshot.takesSnapshot(Mapping.ScreenshotFilePath);
		Thread.sleep(2000);
	}
	
	
	@Test(dependsOnMethods= {"verifyWithdrawal"})
	public void verifyWithdrawalOnLowBalance() throws InterruptedException {
		withdrawalDetails.continueClick();
		Thread.sleep(2000);
		Assert.assertEquals(managerPage.getManageWelcomeText(), Mapping.ManagerWelcome);
		managerPage.withdrawalLinkClick();
		Thread.sleep(2000);
		withdrawalPage.doWithdrawal(Mapping.AccID_2, Mapping.FundAmountTransferLow, Mapping.FundTransferDesc);
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), Mapping.WithdrawalLowBalanceAlert);
		alert.accept();
		Thread.sleep(2000);
	}
	
	@Test(dependsOnMethods= {"verifyWithdrawalOnLowBalance"})
	public void verifyMiniStatement() throws InterruptedException, IOException {
		managerPage.miniStatementClick();
		Thread.sleep(2000);
		Assert.assertEquals(miniStatement.getHeader(), Mapping.MiniStatementHeader);
		miniStatement.doStatement(Mapping.AccID_2);
		Thread.sleep(2000);
		Assert.assertEquals(miniDetails.getHeader(), Mapping.MiniStatementDetailHeader+Mapping.AccID_2);
		map1=miniDetails.getLastTransactionDetails();
		Assert.assertEquals(map1.get("LastTransactionID"), map.get("TransactionID"));
		Assert.assertEquals(map1.get("TypeOfLastTransaction"), "w");
		scrshot.takesSnapshot(Mapping.ScreenshotFilePath);
	}
	
	@Test(dependsOnMethods= {"verifyMiniStatement"})
	public void verifyBalaceEnquiry() throws InterruptedException, IOException {
		miniDetails.ContinueClick();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl().toLowerCase(), Mapping.ManagerHomePageURL.toLowerCase());
		managerPage.balanceEnquiryClick();
		Assert.assertEquals(balanceEnquiry.getHeader(), Mapping.BalanceEnquiryHeader);
		balanceEnquiry.doEnquiry(Mapping.AccID_2);
		Thread.sleep(2000);
		Assert.assertEquals(balanceDetails.getHeader(), Mapping.BalanceDetailsPageHeader+Mapping.AccID_2);
		Assert.assertEquals(balanceDetails.getAccID(), Mapping.AccID_2);
		Assert.assertEquals(balanceDetails.getBalance(), map.get("Balance"));
		scrshot.takesSnapshot(Mapping.ScreenshotFilePath);
		balanceDetails.continueClick();
		Thread.sleep(2000);
	}
	
	@Test(dependsOnMethods= {"verifyBalaceEnquiry"})
	public void verifyCustomizedStatement() throws InterruptedException, IOException {
		Assert.assertEquals(driver.getCurrentUrl().toLowerCase(),Mapping.ManagerHomePageURL.toLowerCase());
		managerPage.customisedStatementClick();
		Thread.sleep(2000);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		String fromDate = dateFormat.format(cal.getTime());
		Date date = new Date();
		String toDate=dateFormat.format(date);
		customizedStatementPage.doCustomizedWithAll(Mapping.AccID_2, fromDate, toDate, Mapping.NumberOfTransactionCustomizedStatement);
		Thread.sleep(2000);
		DateFormat dateFormatEnglish = new SimpleDateFormat("yyyy-MM-dd");
		String fromDateEnglish = dateFormatEnglish.format(cal.getTime());
		String toDateEnglish = dateFormatEnglish.format(date);
		Assert.assertEquals(transactionDetails.getHeader(), Mapping.TransactionDetailsHeaderFirstPart+Mapping.AccID_2+Mapping.TransactionDetailsHeaderMiddlePart+fromDateEnglish+Mapping.TransactionDetailsHeaderLastPart+toDateEnglish);
		Assert.assertEquals(transactionDetails.getLastTransactionID(), map.get("TransactionID"));
		Assert.assertEquals(transactionDetails.getAmountOfLastTransaction(), map.get("Ammount"));
	//	Assert.assertEquals(transactionDetails.getTypeOfLastTransaction(), map.get("ToT"));
		scrshot.takesSnapshot(Mapping.ScreenshotFilePath);
		
	}
	
	@Test(dependsOnMethods= {"verifyCustomizedStatement"})
	public void verifyCustomizedStatementWrongDate() throws InterruptedException {
		driver.navigate().back();
		Thread.sleep(2000);
		Assert.assertEquals(customizedStatementPage.getHeader(), Mapping.CustomizedStatementHeader);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		String fromDate = dateFormat.format(cal.getTime());
		Date date = new Date();
		String toDate=dateFormat.format(date);
		customizedStatementPage.doCustomizedWithAll(Mapping.AccID_2, toDate, fromDate, Mapping.NumberOfTransactionCustomizedStatement);
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), Mapping.WrongDateSelectionAlert);
		alert.accept();
		Thread.sleep(2000);
	}
	

}
