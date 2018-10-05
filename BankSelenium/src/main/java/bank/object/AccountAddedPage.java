package main.java.bank.object;
import org.openqa.selenium.support.*;
import org.openqa.selenium.*;

public class AccountAddedPage {
	@FindBy(xpath="//*[@class='heading3']")
	private WebElement Header;
	
	@FindBy(linkText="Continue")
	private WebElement ContinueLink;
	
	@FindBy(xpath="//*[@id=\"account\"]/tbody/tr[4]/td[2]")
	private WebElement AccountID;
	
	public String getHeader() {
		return Header.getText();
	}
	
	public String getAccID() {
		return AccountID.getText();
	}
	
	public void continueClick() {
		ContinueLink.click();
	}
}
