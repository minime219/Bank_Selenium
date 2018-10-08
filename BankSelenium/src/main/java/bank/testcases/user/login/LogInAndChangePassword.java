package main.java.bank.testcases.user.login;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import main.java.bank.object.LogInPage;
import main.java.bank.object.user.pages.ChangePasswordPage;
import main.java.bank.object.user.pages.CustomerHomePage;
import main.java.bank.testcases.TestCaseObject;

public class LogInAndChangePassword extends TestCaseObject {
	
	LogInPage loginPage;
	CustomerHomePage customerPage;
	ChangePasswordPage changePasswordPage;
	
	@BeforeTest
	public void init() {
		super.setUp(Mapping.LogInURL);
		loginPage = PageFactory.initElements(driver, LogInPage.class);
		customerPage = new CustomerHomePage(driver);
		changePasswordPage = new ChangePasswordPage(driver);
	}
	
	@AfterTest
	public void tearDown() {
		super.tearDown(driver);
	}
	
	@Test
	public void incorrectOldPasswordOnChangePassword() throws InterruptedException {
		loginPage.doLogIn(Mapping.User, Mapping.Password);
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(), Mapping.CustomerHomepageURL);
		Assert.assertEquals(customerPage.getHeader(), Mapping.CustomerPageHeader);
		customerPage.changePasswordLinkClick();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(), Mapping.ChangePasswordURL);
		changePasswordPage.doChangePassword(Mapping.WrongOldPassword, Mapping.NewPassword, Mapping.NewPassword);
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		
		Assert.assertEquals(alert.getText(), Mapping.WrongOldPasswordAlert);
		alert.accept();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(), Mapping.ChangePasswordURL);
		Thread.sleep(2000);
	}
	
	@Test(dependsOnMethods= {"incorrectOldPasswordOnChangePassword"})
	public void verifyAfterPasswordChanged() throws InterruptedException {
		changePasswordPage.doChangePassword(Mapping.Password, Mapping.NewPassword, Mapping.NewPassword);
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		Assert.assertEquals(alertText.toLowerCase(), Mapping.PasswordChangedAlert.toLowerCase());
		System.out.println(alertText.toLowerCase()+"-----"+Mapping.PasswordChangedAlert.toLowerCase());
		alert.accept();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(), Mapping.LogInURL);
	}
	
	@Test(dependsOnMethods = {"verifyAfterPasswordChanged"})
	public void verifyLogInChangedCredential() throws InterruptedException {
		loginPage.doLogIn(Mapping.User, Mapping.NewPassword);
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(), Mapping.CustomerHomepageURL);
		Assert.assertEquals(customerPage.getHeader(), Mapping.CustomerPageHeader);
	}
	
}
