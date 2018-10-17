package main.java.bank.testcases.user.balance;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import main.java.bank.object.LogInPage;
import main.java.bank.object.ScreenshotTake;
import main.java.bank.object.user.pages.BalanceDetailsPage;
import main.java.bank.object.user.pages.BalanceEnquiryPage;
import main.java.bank.object.user.pages.CustomerHomePage;
import main.java.bank.testcases.TestCaseObject;

public class BalanceEnquiry extends TestCaseObject {
//	WebDriver driver;
	LogInPage logInPage;
	CustomerHomePage customerPage;
	BalanceEnquiryPage balanceEnquiryPage;
	BalanceDetailsPage balanceDetailsPage;
	ScreenshotTake scrShot;
	
	@BeforeTest
	public void init() throws MalformedURLException {
		super.setUp(Mapping.LogInURL);
	/*	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		DesiredCapabilities capa = DesiredCapabilities.chrome();
		capa.setBrowserName("chrome");
		capa.setPlatform(Platform.VISTA);
		driver = new RemoteWebDriver(new URL("http://192.168.56.1:4444/wd/hub"), capa); */
		logInPage = PageFactory.initElements(driver, LogInPage.class);
		customerPage = new CustomerHomePage(driver);
		balanceEnquiryPage = new BalanceEnquiryPage(driver);
		balanceDetailsPage = new BalanceDetailsPage(driver);
		scrShot = new ScreenshotTake(driver);
	}
	
	@AfterTest
	public void tearDown() {
		super.tearDown(driver);
	}
	
	@Test
	public void balanceEnquiry() throws InterruptedException, IOException {
		logInPage.doLogIn(Mapping.User, Mapping.Password);
		Thread.sleep(2000);
		customerPage.balanceEnquiryClick();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(), Mapping.BalanceEnquiryURL);
		balanceEnquiryPage.doEnquiry(Mapping.AccID);
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(), Mapping.BalanceDetailsURL);
		Assert.assertEquals(balanceDetailsPage.getHeader(), Mapping.BalanceDetailsHeader+Mapping.AccID);
		Assert.assertEquals(balanceDetailsPage.getAccNo(), Mapping.AccID);
		scrShot.takesSnapshot(Mapping.ScreenshotFilePath);
		
	}
}
