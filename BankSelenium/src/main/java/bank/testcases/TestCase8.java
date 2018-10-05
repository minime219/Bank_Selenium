package main.java.bank.testcases;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;


import main.java.bank.object.AccountAddedPage;
import main.java.bank.object.AddNewAccountPage;
import main.java.bank.object.LogInPage;
import main.java.bank.object.ManagerPage;
import main.java.bank.object.Mapping;

public class TestCase8 extends TestCaseObject{
	
	protected String AccID;
	
	@Test
	public void testAddNewAccount() throws InterruptedException {
		super.setUp(Mapping.LogInURL);
		LogInPage logInPage = PageFactory.initElements(driver, LogInPage.class);
		logInPage.doLogIn(Mapping.User, Mapping.NewPassword);
		Thread.sleep(2000);
		ManagerPage managerPage = PageFactory.initElements(driver, ManagerPage.class);
		managerPage.addNewAccount();
		Thread.sleep(2000);
		AddNewAccountPage newAccount = PageFactory.initElements(driver, AddNewAccountPage.class);
		newAccount.doAddNewAccount(Mapping.CustomerID, Mapping.AccountTyp, Mapping.IniDeposit);
		Thread.sleep(2000);
		
		AccountAddedPage accPage = PageFactory.initElements(driver, AccountAddedPage.class);
		System.out.println(accPage.getAccID());
		Assert.assertEquals(accPage.getHeader(), Mapping.AccountAddedSuccess);
		//Assert.assertEquals(Mapping.AccountAddedSuccess, accPage.getHeader());
		this.AccID=accPage.getAccID();
		accPage.continueClick();
		
	//	super.tearDown(driver);
	}
	
	public String getAccID() {
		return this.AccID;
	}
	
	public void tearDown() {
		super.tearDown(driver);
	}
}
