package main.java.bank.testcases.user.ministatement;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import main.java.bank.object.LogInPage;
import main.java.bank.object.ScreenshotTake;
import main.java.bank.object.user.pages.MiniStatementPage;
import main.java.bank.object.user.pages.CustomerHomePage;
import main.java.bank.object.user.pages.MiniStatementDetailsPage;
import main.java.bank.testcases.TestCaseObject;

public class MiniStatement extends TestCaseObject {
	
	LogInPage logInPage;
	CustomerHomePage customerHomePage;
	MiniStatementPage miniStatementPage;
	MiniStatementDetailsPage miniStatementDetailsPage;
	ScreenshotTake scrshot;
	
	@BeforeTest
	public void init() {
		super.setUp(Mapping.LogInURL);
		logInPage = PageFactory.initElements(driver, LogInPage.class);
		customerHomePage = new CustomerHomePage(driver);
		miniStatementPage = new MiniStatementPage(driver);
		miniStatementDetailsPage = new MiniStatementDetailsPage(driver);
		scrshot = new ScreenshotTake(driver);
	}
	
	@AfterTest
	public void tearDown() {
		super.tearDown(driver);
	}
	
	@Test
	public void verifyMiniStatement() throws InterruptedException, IOException {
		logInPage.doLogIn(Mapping.User, Mapping.Password);
		Thread.sleep(2000);
		customerHomePage.miniStatementLinkClick();
		Thread.sleep(2000);
		miniStatementPage.doMiniStatement(Mapping.AccID);
		Thread.sleep(2000);
		scrshot.takesSnapshot(Mapping.ScreenshotFilePath);
		miniStatementDetailsPage.continueLinkClick();
		
	}
	
	@Test(dependsOnMethods= {"verifyMiniStatement"})
	public void verifyWrongAcc() throws InterruptedException {
		customerHomePage.miniStatementLinkClick();
		miniStatementPage.doMiniStatement(Mapping.WrongAccID);
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), Mapping.WrongAccNoAlert);
		alert.accept();
		Thread.sleep(2000);
	}
	
	@Test(dependsOnMethods= {"verifyWrongAcc"})
	public void verifyNonExistAcc() throws InterruptedException {
		miniStatementPage.doMiniStatement(Mapping.NonExistAccNo);
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), Mapping.NonExistAccAlert);
		alert.accept();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(), Mapping.StatementInputURL);
	}
}
