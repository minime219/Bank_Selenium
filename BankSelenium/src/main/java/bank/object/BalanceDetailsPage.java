package main.java.bank.object;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class BalanceDetailsPage {
	
	@FindBy(xpath="//p[@class='heading3']")
	private WebElement Header;
	
	@FindBy(xpath="//*[@id=\"balenquiry\"]/tbody/tr[6]/td[2]")
	private WebElement AccountID;
	
	@FindBy (xpath="//*[@id=\"balenquiry\"]/tbody/tr[16]/td[2]")
	private WebElement Balance;
	
	@FindBy(linkText="Continue")
	private WebElement ContinueLink;
	
	public String getHeader() {
		return Header.getText();
	}
	
	public String getAccID() {
		return AccountID.getText();
	}
	
	public String getBalance() {
		return Balance.getText();
	}
	
	public void continueClick() {
		ContinueLink.click();
	}

}
