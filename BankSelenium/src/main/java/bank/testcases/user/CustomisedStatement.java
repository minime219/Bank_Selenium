package main.java.bank.testcases.user;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import main.java.bank.object.CustomizedStatementPage;
import main.java.bank.object.LogInPage;
import main.java.bank.object.user.pages.CustomerHomePage;
import main.java.bank.testcases.TestCaseObject;
import main.java.bank.testcases.user.balance.Mapping;

import org.testng.Assert;

public class CustomisedStatement extends TestCaseObject {
	
	LogInPage logInPage;
	CustomerHomePage customerHomePage;
	CustomizedStatementPage customizedStatementPage;
	
	@BeforeTest
	public void init() {
		super.setUp(Mapping.LogInURL);
		logInPage = PageFactory.initElements(driver, LogInPage.class);
		customerHomePage = new CustomerHomePage(driver);
		customizedStatementPage = PageFactory.initElements(driver, CustomizedStatementPage.class);
		
	}
	
	@AfterTest
	public void tearDown() {
		super.tearDown(driver);
	}
	
	@Test
	public void verifyStatementOnWrongAcc() throws InterruptedException {
		logInPage.doLogIn(Mapping.User, Mapping.Password);
		Thread.sleep(2000);
		customerHomePage.customisedStatementClick();
		Thread.sleep(2000);
		customizedStatementPage.doCustomized(Mapping.PayeeAcc);
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), Mapping.StatementWrongAccAlert);
		alert.accept();
		Thread.sleep(2000);
		}
	
	@Test(dependsOnMethods= {"verifyStatementOnWrongAcc"})
	public void verifyOnNotExistAccNo() throws InterruptedException{
		customizedStatementPage.doCustomized(Mapping.AccNotExist);
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), Mapping.StatementNotExistAccAlert);
		alert.accept();
		Thread.sleep(2000);
	}
	
	@Test(dependsOnMethods = {"verifyOnNotExistAccNo"})
	public void verifyOnWrongDateInput() throws InterruptedException {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		String toDate = dateFormat.format(date).toString();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		String fromDate = dateFormat.format(cal.getTime());
		
		customizedStatementPage.doCustomizedWithAll(Mapping.AccID, toDate, fromDate, Mapping.NoOfTrans);
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), Mapping.StatementWrongDateInputAlert);
		alert.accept();
		Thread.sleep(2000);
		
	}
}
