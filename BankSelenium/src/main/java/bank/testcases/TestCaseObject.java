package main.java.bank.testcases;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCaseObject {
	
	protected WebDriver driver;
	
/*	public TestCaseObject() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
	}*/
	
	
	public void setUp(String url) {
	
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	//	this.driver = driver;
	}
	
	public void tearDown(WebDriver driver) {
		driver.quit();
	}

}
