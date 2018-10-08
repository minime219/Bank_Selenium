package main.java.bank.object.user.pages;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.bank.testcases.TestCaseObject;

import org.openqa.selenium.*;

public class MiniStatementDetailsPage extends TestCaseObject {
	
	@FindBy(linkText = "Continue")
	private WebElement ContinueLink;
	
	private WebDriver driver;
	
	public MiniStatementDetailsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void continueLinkClick() {
		ContinueLink.click();
	}
}
