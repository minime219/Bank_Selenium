package main.java.bank.testcases;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import main.java.bank.object.AddNewCustomerPage;
import main.java.bank.object.CustomerRegisteredPage;
import main.java.bank.object.LogInPage;
import main.java.bank.object.ManagerPage;
import main.java.bank.object.Mapping;

public class TestCase7 extends TestCaseObject {
	
	public String CustomerID;
	public ManagerPage managerPage;
	public LogInPage loginPage;
	
	@BeforeTest
	public void setUp() {
		super.setUp(Mapping.LogInURL);
		
		
	}
	
	@AfterTest
	public void tearDown() {
		super.tearDown(driver);
		
	}
	
	@Test
	public void testLogIn() throws InterruptedException {
		loginPage = PageFactory.initElements(driver, LogInPage.class);
		loginPage.doLogIn(Mapping.User, Mapping.NewPassword);
		Thread.sleep(2000);
	}
	
	@Test (dependsOnMethods= {"testLogIn"})
	public void addNewCustomer() throws InterruptedException {
		
		managerPage= PageFactory.initElements(driver, ManagerPage.class);
		managerPage.addNewCustomer();
		Thread.sleep(2000);
		AddNewCustomerPage newCustomer = PageFactory.initElements(driver, AddNewCustomerPage.class);
	//	try {
		newCustomer.doAddCustomer(Mapping.CustomerName, Mapping.CustomerGende, Mapping.CustomerBirthday, Mapping.CustomerAddress, Mapping.CustomerCity, Mapping.CustomerState, Mapping.CustomerPin, Mapping.CustomerMobile, "Test_10_"+Integer.toString((int)Math.random()*10)+"@test.com", Mapping.CustomerPassword);
			Thread.sleep(2000);
	/*		while (ExpectedConditions.alertIsPresent()!=null) {
				Alert alert= driver.switchTo().alert();
				alert.accept();
				Thread.sleep(2000);
				newCustomer.doAddCustomer(Mapping.CustomerName, Mapping.CustomerGende, Mapping.CustomerBirthday, Mapping.CustomerAddress, Mapping.CustomerCity, Mapping.CustomerState, Mapping.CustomerPin, Mapping.CustomerMobile, "Test_1_"+Integer.toString((int)Math.random()*100)+"@test.com", Mapping.CustomerPassword);
			//	Thread.sleep(2000);
			}*/
	
	
		
		
		Thread.sleep(2000);
		CustomerRegisteredPage customerRegister = PageFactory.initElements(driver, CustomerRegisteredPage.class);
		Assert.assertEquals(customerRegister.getHeader(), Mapping.CustomerRegisteredSuccessfull); 
		
		CustomerID = customerRegister.getID();
		System.out.println(CustomerID);
		customerRegister.continueClick();
	}
	
	public String getCustomerID() {
		return this.CustomerID;
	}
	
/*	public TestCase7 (WebDriver driver) {
		this.driver=driver;
	} */
	

}
