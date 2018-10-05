package main.java.bank.testcases;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import main.java.bank.object.LogInPage;
import main.java.bank.object.ManagerPage;
import main.java.bank.object.Mapping;
import main.java.bank.object.PasswordInput;

public class TestCase6 extends TestCaseObject {
	
	@BeforeTest
	public void setUp() {
		super.setUp(Mapping.LogInURL);
	}
	
	@AfterTest
	public void tearDown() {
		super.tearDown(driver);
	}
	
	@Test
	public void verifiedChangePassword() throws InterruptedException {
		LogInPage loginPage = PageFactory.initElements(driver, LogInPage.class);
		loginPage.doLogIn(Mapping.User, Mapping.NewPassword);
		Thread.sleep(2000);
		ManagerPage managerPage = PageFactory.initElements(driver, ManagerPage.class);
		managerPage.changePassword();
		Thread.sleep(2000);
		PasswordInput passwordInput = PageFactory.initElements(driver, PasswordInput.class);
		passwordInput.doChangePassword(Mapping.NewPassword, Mapping.Password, Mapping.Password);
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), Mapping.ChangePasswordAlert);
		alert.accept();
		Thread.sleep(2000);
		Assert.assertEquals(Mapping.LogInURL, driver.getCurrentUrl());
	}
}
