package main.java.bank.testcases;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import main.java.bank.object.LogInPage;
import main.java.bank.object.ManagerPage;
import main.java.bank.object.Mapping;
import main.java.bank.object.PasswordInput;

public class TestCase5 extends TestCaseObject {
	
	@BeforeTest
	public void setUp() {
		super.setUp(Mapping.LogInURL);
	}
	
	@AfterTest
	public void tearDown() {
		super.tearDown(driver);
	}
	
	@Test
	public void logIn() throws InterruptedException {
		LogInPage page = PageFactory.initElements(driver, LogInPage.class);
		page.doLogIn(Mapping.User, Mapping.Password);
		Thread.sleep(2000);
		ManagerPage page1 = PageFactory.initElements(driver, ManagerPage.class);
		Assert.assertEquals(page1.getManageWelcomeText(), Mapping.ManagerWelcome);
		page1.changePassword();
		Thread.sleep(2000);
		PasswordInput passInputPage = PageFactory.initElements(driver, PasswordInput.class);
		passInputPage.doChangePassword(Mapping.OldPasswordFalse, Mapping.NewPassword, Mapping.NewPassword);
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), Mapping.FalseOldPasswordAlert);
		alert.accept();
		Thread.sleep(2000);
		Assert.assertEquals(passInputPage.getHeader(), Mapping.HeaderChangePassword);
	}
	
/*	@Test
	public void changePassword() throws InterruptedException {
		System.out.println(driver.findElement(By.xpath("//*[@class='heading3']")).getText());
		driver.findElement(By.xpath("//input[@name='oldpassword']")).sendKeys("Test");
		Thread.sleep(2000);
		PasswordInput passInputPage = PageFactory.initElements(driver, PasswordInput.class);
		passInputPage.doChangePassword(Mapping.OldPasswordFalse, Mapping.NewPassword, Mapping.NewPassword);
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), Mapping.FalseOldPasswordAlert);
		alert.accept();
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		
	}*/
	

}
