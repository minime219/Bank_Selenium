package main.java.bank.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import main.java.bank.object.AddNewCustomerPage;
import main.java.bank.object.CustomerRegisteredPage;
import main.java.bank.object.DeleteCustomerPage;
import main.java.bank.object.EditCustomerPage;
import main.java.bank.object.LogInPage;
import main.java.bank.object.ManagerPage;
import main.java.bank.object.Mapping;

public class TestCase11 extends TestCaseObject {
	public ManagerPage managerPage;
	public LogInPage logInPage;
	public DeleteCustomerPage deleteCusPage;
	public TestCase7 tc7;
	public String cusID;
	@BeforeTest
	public void setUp() {
		super.setUp(Mapping.LogInURL);
		logInPage = PageFactory.initElements(driver, LogInPage.class);
		managerPage = PageFactory.initElements(driver, ManagerPage.class);
		deleteCusPage = PageFactory.initElements(driver, DeleteCustomerPage.class);
	}
	
	@AfterTest
	public void tearDown() {
		super.tearDown(driver);
	}
	
	@Test
	public void verifyConfirmationMessage() throws InterruptedException {
		logInPage.doLogIn(Mapping.User, Mapping.NewPassword);
		Thread.sleep(2000);
		managerPage.deleteCustomerClick();
		Thread.sleep(2000);
		deleteCusPage.doDelete(Mapping.CustomerID);
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), Mapping.DeleteCustomerAlert);
		alert.dismiss();
		
	}
	
	@Test(dependsOnMethods= {"verifyConfirmationMessage"})
	public void verifyCustomerNotDelete() throws InterruptedException {
		deleteCusPage.doDelete(Mapping.CustomerID);
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), Mapping.DeleteCustomerNotAvaiAlert);
		alert.accept();
	}
	
	@Test(dependsOnMethods= {"verifyCustomerNotDelete"})
	public void deleteCustomer() throws InterruptedException {
		managerPage.addNewCustomer();
		AddNewCustomerPage addNewCustomer = PageFactory.initElements(driver, AddNewCustomerPage.class);
		addNewCustomer.doAddCustomer(Mapping.CustomerName, Mapping.CustomerGende, Mapping.CustomerBirthday, Mapping.CustomerAddress, Mapping.CustomerCity, Mapping.CustomerState, Mapping.CustomerPin, Mapping.CustomerMobile, "test_2_"+Integer.toString((int)(Math.random()*10))+"@test.com", Mapping.CustomerPassword);
		Thread.sleep(2000);
		CustomerRegisteredPage customerRegis = PageFactory.initElements(driver, CustomerRegisteredPage.class);
		cusID = customerRegis.getID();
		customerRegis.continueClick();
		managerPage.deleteCustomerClick();
		deleteCusPage.doDelete(cusID);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), Mapping.DeleteCustomerSuccessAlert);
		alert.accept();
		
	}
	
	@Test(dependsOnMethods = {"deleteCustomer"})
	public void verifyEditNonCustomerID()throws InterruptedException {
		
		managerPage.editCustomerClick();
		EditCustomerPage editCus = PageFactory.initElements(driver, EditCustomerPage.class);
		editCus.doEdit(cusID);
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), Mapping.CustomerNotExistAlert);
		alert.accept();
		Thread.sleep(2000);
		Assert.assertEquals(editCus.getHeader(), Mapping.EditCustomerHeader);
	}
	
	@Test(dependsOnMethods = {"verifyEditNonCustomerID"})
	public void verifyDeleteNonExistCustomer() throws InterruptedException {
		managerPage.deleteCustomerClick();
		deleteCusPage.doDelete(cusID);
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(2000);
		alert=driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), Mapping.CustomerNotExistAlert);
		alert.accept();
		Thread.sleep(2000);
		Assert.assertEquals(deleteCusPage.getHeader(), Mapping.DeleteCustomerHeader);
	}
	
	
}
