package main.java.bank.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import main.java.bank.object.LogInPage;
import main.java.bank.object.ManagerPage;
import main.java.bank.object.Mapping;

public class TestCase1 extends TestCaseObject {
	
	//private WebDriver driver;
	
	
	@BeforeTest
	public void setUp() {
		
	//	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
	//	driver = new ChromeDriver();
		
		super.setUp(Mapping.LogInURL);
		
	}
	
	@Test
	public void testLogIn() throws InterruptedException {
		LogInPage page = PageFactory.initElements(driver, LogInPage.class);
	//	LogInPage page = new LogInPage(driver);
		Thread.sleep(2000);
		page.doLogIn(Mapping.User, Mapping.Password);
		Thread.sleep(2000);
		ManagerPage page1 = PageFactory.initElements(driver, ManagerPage.class);
		String welcome = page1.getManageWelcomeText();
	//	String welcome = driver.findElement(By.xpath(Mapping.ManagerXpath)).getText();
		System.out.println(welcome);
		Assert.assertEquals(welcome, Mapping.ManagerWelcome);
	//	super.tearDown(driver);
	}
	
	@AfterTest
	public void tearDown() {
		super.tearDown(driver);
	}

}
