package main.java.bank.testcases;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.*;

import main.java.bank.object.BalanceEnquiryPage;
import main.java.bank.object.CustomizedStatementPage;
import main.java.bank.object.DeleteAccountPage;
import main.java.bank.object.ManagerPage;
import main.java.bank.object.Mapping;
import main.java.bank.object.MiniStatementPage;

public class TestCase9 extends TestCaseObject{
	public TestCase8 tc8;
	public ManagerPage managerPage;
	
	@BeforeTest
	public void setUp() throws InterruptedException {
		tc8 = new TestCase8();
		tc8.testAddNewAccount();
	}
	
	@Test
	public void deleteAccount() throws InterruptedException {
	//	super.setUp(url);
		
		managerPage = PageFactory.initElements(tc8.driver, ManagerPage.class);
		managerPage.deleteAccount();
		DeleteAccountPage deleteAcc = PageFactory.initElements(tc8.driver, DeleteAccountPage.class);
		deleteAcc.doDelete(tc8.getAccID());
		Thread.sleep(2000);
		Alert alert = tc8.driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), Mapping.AccountDeleteAlert);
		alert.accept();
		Thread.sleep(2000);
		Alert alertNew= tc8.driver.switchTo().alert();
		Assert.assertEquals(alertNew.getText(), Mapping.AccountDeleteSuccessAlert);
		alertNew.accept();
		Thread.sleep(2000);
		//Assert.assertEquals(tc8.driver.getCurrentUrl(), Mapping.ManagerHomePageURL);
		//ManagerPage managerPage = PageFactory.initElements(driver, ManagerPage.class);
		Assert.assertEquals(managerPage.getManageWelcomeText(), Mapping.ManagerWelcome);
		managerPage.miniStatementClick();
		Thread.sleep(2000);
		MiniStatementPage miniPage = PageFactory.initElements(tc8.driver, MiniStatementPage.class);
		miniPage.doStatement(tc8.getAccID());
		Alert alertAcc = tc8.driver.switchTo().alert();
		Assert.assertEquals(alertAcc.getText(), Mapping.AccountNotExistAlert);
		//Thread.sleep(2000);
		alertAcc.accept();
		Thread.sleep(2000);
		Assert.assertEquals(miniPage.getHeader(), Mapping.MiniStatementHeader);
		
	}
	
	@Test(dependsOnMethods= {"deleteAccount"})
	public void verifiedBalance() throws InterruptedException {
	//	ManagerPage managerPage = PageFactory.initElements(tc8.driver, ManagerPage.class);
		managerPage.balanceEnquiryClick();
		BalanceEnquiryPage balancePage = PageFactory.initElements(tc8.driver, BalanceEnquiryPage.class);
		balancePage.doEnquiry(tc8.getAccID());
		Thread.sleep(2000);
		Alert alert = tc8.driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), Mapping.AccountNotExistAlert);
		alert.accept();
		Thread.sleep(2000);
		Assert.assertEquals(balancePage.getHeader(), Mapping.BalanceEnquiryHeader);
		balancePage.homeLinkClick();
		
	}
	
	@Test(dependsOnMethods= {"deleteAccount"})
	public void verifiedCustomizedStatement() throws InterruptedException {
		managerPage.customisedStatementClick();
		CustomizedStatementPage customisedPage = PageFactory.initElements(tc8.driver, CustomizedStatementPage.class);
		customisedPage.doCustomized(tc8.getAccID());
		Thread.sleep(2000);
		Alert alert = tc8.driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), Mapping.AccountNotExistAlert);
		alert.accept();
		Assert.assertEquals(customisedPage.getHeader(), Mapping.CustomizedStatementHeader);

	}
	
	@AfterTest()
	public void tearDown() {
		tc8.driver.close();
	}
	
}
