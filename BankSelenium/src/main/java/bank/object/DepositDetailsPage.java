package main.java.bank.object;
import org.openqa.selenium.support.*;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.*;
public class DepositDetailsPage {
	
	@FindBy(xpath="//p[@class='heading3']")
	private WebElement Header;
	
	@FindBy(xpath="//*[@id=\"deposit\"]/tbody/tr[6]/td[2]")
	private WebElement TransactionsID;
	
	@FindBy(xpath="//*[@id=\"deposit\"]/tbody/tr[7]/td[2]")
	private WebElement AccountID;
	
	@FindBy(xpath="//*[@id=\"deposit\"]/tbody/tr[12]/td[2]")
	private WebElement Ammount;
	
	@FindBy(xpath="//*[@id=\"deposit\"]/tbody/tr[12]/td[2]")
	private WebElement TypeOfTransaction;
	
	@FindBy(xpath="//*[@id=\"deposit\"]/tbody/tr[20]/td[2]")
	private WebElement Desc;
	
	@FindBy(xpath="//*[@id=\"deposit\"]/tbody/tr[20]/td[2]")
	private WebElement CurrentBalance;
	
	public String getHeader() {
		return Header.getText();
	}
	
	public Map<String,String> getDepositDetails() {
		Map<String,String> map = new HashMap<String,String>();
		
		map.put("TransactionID", TransactionsID.getText());
		map.put("AccountID", AccountID.getText());
		map.put("Ammount", Ammount.getText());
		map.put("Type", TypeOfTransaction.getText());
		map.put("Desc", Desc.getText());
		map.put("Balance", CurrentBalance.getText());
		return map;
	}
	
	
	
	

}
