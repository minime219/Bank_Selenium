package main.java.bank.object;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class FundTransferDetails {
	
	@FindBy(xpath="/html/body/table/tbody/tr[2]/td/table/tbody/tr[1]/td[2]")
	private WebElement FromAccNo;
	
	@FindBy(xpath="/html/body/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]")
	private WebElement ToAccNo;
	
	@FindBy(xpath="/html/body/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]")
	private WebElement Amount;
	
	@FindBy(xpath="/html/body/table/tbody/tr[2]/td/table/tbody/tr[4]/td[2]")
	private WebElement Desc;
	
	@FindBy(linkText="Continue")
	private WebElement ContinueLink;
	
	public String getFromAccNo() {
		return FromAccNo.getText();
	}
	
	public String getToAccNo() {
		return ToAccNo.getText();
	}
	
	public String getAmount() {
		return Amount.getText();
	}
	
	public String getDesc() {
		return Desc.getText();
	}
	
	public void continueClick() {
		ContinueLink.click();
	}
}
