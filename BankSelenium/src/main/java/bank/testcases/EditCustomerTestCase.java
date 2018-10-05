package main.java.bank.testcases;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import main.java.bank.object.EditCustomerDetailsPage;
import main.java.bank.object.EditCustomerPage;
import main.java.bank.object.LogInPage;
import main.java.bank.object.ManagerPage;
import main.java.bank.object.Mapping;


public class EditCustomerTestCase extends TestCaseObject {
	
	ManagerPage managerPage;
	EditCustomerPage editCus;
	LogInPage loginPage;
	EditCustomerDetailsPage editDetails;
	
	@BeforeTest
	public void init() {
		super.setUp(Mapping.LogInURL);
		managerPage = PageFactory.initElements(driver, ManagerPage.class);
		editCus = PageFactory.initElements(driver, EditCustomerPage.class);
		loginPage = PageFactory.initElements(driver, LogInPage.class);
		editDetails = PageFactory.initElements(driver, EditCustomerDetailsPage.class);
	}
	
	@AfterTest
	public void tearDown() {
		super.tearDown(driver);
	}
	
	@Test
	public void verifyEditCustomer() throws InterruptedException {
	//	Assert.assertEquals(, actual);
		loginPage.doLogIn(Mapping.User, Mapping.NewPassword);
		Thread.sleep(2000);
		Assert.assertEquals(managerPage.getManageWelcomeText(), Mapping.ManagerWelcome);
		managerPage.editCustomerClick();
		Thread.sleep(2000);
		Assert.assertEquals(editCus.getHeader(), Mapping.EditCustomerHeader);
		editCus.doEdit(Mapping.CustomerID_2);
		Thread.sleep(2000);
		Map<String,String> map = new HashMap<String,String>();
		map=editDetails.getCustomerDetails();
		Assert.assertEquals(map.get("name"), Mapping.CustomerName);
		Assert.assertEquals(map.get("gender"), Mapping.CustomerGende);
	//	Assert.assertEquals(map.get("dob"), Mapping.CustomerBirthday.replaceAll(".", "-"));
		
	}
}
