package main.java.bank.testcases;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import main.java.bank.object.CustomizedStatementPage;
import main.java.bank.object.FundTransferDetails;
import main.java.bank.object.FundTransferPage;
import main.java.bank.object.LogInPage;
import main.java.bank.object.ManagerPage;
import main.java.bank.object.Mapping;
import main.java.bank.object.TransactionsDetails;

public class FundTransferAndCutomizedStatement extends TestCaseObject {
	
	LogInPage loginPage;
	ManagerPage managerPage;
	FundTransferPage fundTransferPage;
	FundTransferDetails fundDetails;
	CustomizedStatementPage custStatePage;
	TransactionsDetails details;
	
	
	@BeforeTest
	public void setUp() {
		super.setUp(Mapping.LogInURL);
		loginPage = PageFactory.initElements(driver, LogInPage.class);
		managerPage = PageFactory.initElements(driver, ManagerPage.class);
		fundTransferPage = PageFactory.initElements(driver, FundTransferPage.class);
		fundDetails = PageFactory.initElements(driver, FundTransferDetails.class);
		custStatePage = PageFactory.initElements(driver, CustomizedStatementPage.class);
		details = new TransactionsDetails(driver);
		loginPage.doLogIn(Mapping.User, Mapping.NewPassword);

	}
	
	@AfterTest
	public void tearDown() {
		super.tearDown(driver);
	}
	
//	@Ignore
	@Test
	public void verifyFundTransfers() throws InterruptedException {
		managerPage.fundTransferClick();
		Thread.sleep(2000);
		fundTransferPage.doTransfer(Mapping.AccID_2, Mapping.AccountID, Mapping.FundTransferAmount, Mapping.FundTransferDesc);
		Thread.sleep(2000);
		Assert.assertEquals(fundDetails.getFromAccNo(), Mapping.AccID_2);
		Assert.assertEquals(fundDetails.getToAccNo(), Mapping.AccountID);
		Assert.assertEquals(fundDetails.getAmount(), Mapping.FundTransferAmount);
		Assert.assertEquals(fundDetails.getDesc(), Mapping.FundTransferDesc);
		}
//	@Ignore
	@Test(dependsOnMethods= {"verifyFundTransfers"})
	public void reloadedVerifyFundTransfer() throws InterruptedException {
		verifyFundTransfers();
		driver.navigate().refresh();
		Thread.sleep(2000);
		Assert.assertEquals(fundTransferPage.getHeader(), Mapping.FundTransferHeader);
	}
	
	@Test (dependsOnMethods= {"reloadedVerifyFundTransfer"})
	public void verifyTransferDetails () throws InterruptedException {
		managerPage.customisedStatementClick();
		custStatePage.doCustomized(Mapping.AccID_2);
	//	System.out.println("No of row: "+details.getNoOfRow());
	//	System.out.println("No of col:" +details.getNoofCol());
		System.out.println(details.getAmountOfLastTransaction());
		Assert.assertEquals(details.getAmountOfLastTransaction(), Mapping.FundTransferAmount);
		System.out.println(details.getDateOfLastTransaction());
		Date dateNow = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Assert.assertEquals(details.getDateOfLastTransaction(), sdf.format(dateNow));
		System.out.println(details.getDescofLastTransaction());
		Assert.assertEquals(details.getDescofLastTransaction(), Mapping.TransferDetailsDesc+Mapping.AccountID);
		details.continueClick();
		Thread.sleep(2000);
	}
	
	@Test(dependsOnMethods= {"verifyTransferDetails"})
	public void verifyTransferWrongAcc() throws InterruptedException {
		managerPage.fundTransferClick();
		Thread.sleep(2000);
		fundTransferPage.doTransfer(Mapping.AccID_2, Mapping.AccNotExist, Mapping.FundTransferAmount, Mapping.FundTransferDesc);
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), Mapping.AccountNotExistAlertFirstPart+Mapping.AccNotExist+Mapping.AccountNotExistAlertLastPart);
		alert.accept();
		Thread.sleep(2000);
	}
	
	@Test(dependsOnMethods = {"verifyTransferWrongAcc"})
	public void verifyTransferSameAcc() throws InterruptedException {
		managerPage.fundTransferClick();
		fundTransferPage.doTransfer(Mapping.AccID_2, Mapping.AccID_2, Mapping.FundTransferAmount, Mapping.FundTransferDesc);
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), Mapping.FundTransferSameAccAlert);
		alert.accept();
		Thread.sleep(2000);
		}
	
	@Test(dependsOnMethods = {"verifyTransferSameAcc"})
	public void verifyTransferFundHigh() throws InterruptedException {
		managerPage.fundTransferClick();
		fundTransferPage.doTransfer(Mapping.AccID_2, Mapping.AccountID, Mapping.FundAmountTransferLow, Mapping.FundTransferDesc);
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), Mapping.FundTransferLowAlert);
		alert.accept();
	}

}
