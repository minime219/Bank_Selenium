package main.java.bank.object;
import org.openqa.selenium.support.*;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.*;
public class WithdrawalDetailsPage {
	
	@FindBy(xpath="//p[@class='heading3']")
	private WebElement Header;
	
	@FindBy(xpath="//*[@id=\"withdraw\"]/tbody/tr[6]/td[2]")
	private WebElement TransactionID;
	
	@FindBy(xpath="//*[@id=\"withdraw\"]/tbody/tr[7]/td[2]")
	private WebElement AccountID;
	
	@FindBy(xpath="//*[@id=\"withdraw\"]/tbody/tr[16]/td[2]")
	private WebElement TypeOfTransaction;
	
	@FindBy(xpath="//*[@id=\"withdraw\"]/tbody/tr[20]/td[2]")
	private WebElement Desc;
	
	@FindBy(xpath="//*[@id=\"withdraw\"]/tbody/tr[23]/td[2]")
	private WebElement CurrentBalance;
	
	@FindBy(xpath="//*[@id=\"withdraw\"]/tbody/tr[12]/td[2]")
	private WebElement Ammount;
	
	@FindBy(linkText="Continue")
	private WebElement ContinueLink;
	
	public String getHeader() {
		return Header.getText();
	}
	
	public Map<String,String> getWithdrawalDetails(){
		Map<String,String> map = new HashMap<String,String>();
		map.put("AccountID", AccountID.getText());
		map.put("TransactionID", TransactionID.getText());
		map.put("ToT", TypeOfTransaction.getText());
		map.put("Ammount", Ammount.getText());
		map.put("Desc", Desc.getText());
		map.put("Balance", CurrentBalance.getText());
		return map;
	}
	
	public void continueClick() {
		ContinueLink.click();
	}

}
