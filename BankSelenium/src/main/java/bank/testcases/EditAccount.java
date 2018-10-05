package main.java.bank.testcases;
import org.testng.annotations.*;

import main.java.bank.object.AddNewCustomerPage;
import main.java.bank.object.CustomerRegisteredPage;
import main.java.bank.object.EditAccountDetails;
import main.java.bank.object.EditAccountPage;
import main.java.bank.object.LogInPage;
import main.java.bank.object.ManagerPage;
import main.java.bank.object.Mapping;
import main.java.bank.object.ScreenshotTake;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class EditAccount extends TestCaseObject {
	
	LogInPage logInPage;
	ManagerPage managerPage;
	EditAccountPage editAccountPage;
	EditAccountDetails editAccDetails;
	AddNewCustomerPage addNewCustomer;
	CustomerRegisteredPage customerDetails;
	ScreenshotTake scrShot;
	
	@BeforeTest
	public void init() {
		super.setUp(Mapping.LogInURL);
		logInPage = PageFactory.initElements(driver, LogInPage.class);
		managerPage = PageFactory.initElements(driver, ManagerPage.class);
		editAccountPage = PageFactory.initElements(driver, EditAccountPage.class);
		editAccDetails = PageFactory.initElements(driver, EditAccountDetails.class);
		addNewCustomer = PageFactory.initElements(driver, AddNewCustomerPage.class);
		customerDetails = PageFactory.initElements(driver, CustomerRegisteredPage.class);
		scrShot = new ScreenshotTake(driver);
	}
	
	@AfterTest
	public void tearDown() {
		super.tearDown(driver);
	}
	
	@Test
	public void verifyEditAccount() throws InterruptedException, IOException {
		logInPage.doLogIn(Mapping.User, Mapping.NewPassword);
		Thread.sleep(2000);
		managerPage.editAccountClick();
		Thread.sleep(2000);
		Assert.assertEquals(editAccountPage.getHeader(), Mapping.EditAccPageHeader);
		editAccountPage.doEditAcc(Mapping.AccID_2);
		Thread.sleep(2000);
		Assert.assertEquals(editAccDetails.getCustomerID(), Mapping.CustomerID_2);
		scrShot.takesSnapshot(Mapping.ScreenshotFilePath);
		editAccDetails.homeLinkClick();
	}
	
	@Test(dependsOnMethods= {"verifyEditAccount"})
	public void verifyLogOut() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl().toLowerCase(), Mapping.ManagerHomePageURL.toLowerCase());
		managerPage.logOutLinkClick();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), Mapping.LogOutAlert);
		alert.accept();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl().toLowerCase(), Mapping.LogInURL.toLowerCase());
	}
	
	@Test(dependsOnMethods = {"verifyLogOut"})
	public void verifyUserCreated() throws InterruptedException, IOException {
		logInPage.doLogIn(Mapping.User, Mapping.NewPassword);
		Thread.sleep(2000);
		managerPage.addNewCustomer();
		Thread.sleep(2000);
		addNewCustomer.doAddCustomer(Mapping.CustomerName, Mapping.CustomerGende, Mapping.CustomerBirthday, Mapping.CustomerAddress, Mapping.CustomerCity, Mapping.CustomerState, Mapping.CustomerPin, Mapping.CustomerMobile, "Test_11_"+Integer.toString((int)Math.random()*10)+"@test.com", Mapping.NewPassword);
		Thread.sleep(2000);
		scrShot.takesSnapshot(Mapping.ScreenshotFilePath);
		System.out.println(customerDetails.getID());
		String customerID = customerDetails.getID();
		customerDetails.continueClick();
		Thread.sleep(2000);
		managerPage.logOutLinkClick();
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		logInPage.doLogIn(customerID, Mapping.NewPassword);
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(), Mapping.CustomerHomePageURL);
	}

}
