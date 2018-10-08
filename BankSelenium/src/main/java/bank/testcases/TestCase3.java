package main.java.bank.testcases;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import main.java.bank.object.DataProviderClass;
import main.java.bank.object.LogInPage;
import main.java.bank.object.ManagerPage;
import main.java.bank.object.Mapping;

public class TestCase3 extends TestCaseObject {
	
	@BeforeTest
	public void setUp() {
		super.setUp(Mapping.LogInURL);
	}
	
	
	@Test(dataProvider="LogInProvider",dataProviderClass = DataProviderClass.class )
	public void testLogin(String username, String password) {
		LogInPage page = PageFactory.initElements(driver, LogInPage.class);
		page.doLogIn(username, password);
		try {
			Alert alert =	driver.switchTo().alert();
			Assert.assertEquals(Mapping.LogInAlert, alert.getText());
		} catch (NoAlertPresentException e) {
			// TODO: handle exception
			ManagerPage page1 = PageFactory.initElements(driver, ManagerPage.class);
			Assert.assertEquals(page1.getManageWelcomeText(), Mapping.ManagerWelcome);
		}
		driver.close();
		super.setUp(Mapping.LogInURL);
	}
	
	@AfterTest
	public void tearDown() {
		super.tearDown(driver);
	}

}
