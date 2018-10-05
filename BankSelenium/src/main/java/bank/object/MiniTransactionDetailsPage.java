package main.java.bank.object;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
public class MiniTransactionDetailsPage {
	
	@FindBy(xpath="//p[@class='heading3']")
	private WebElement Header;
	
	@FindBy(xpath="//*[@id=\"ministmt\"]/tbody/tr[2]/td[1]")
	private WebElement LastTransactionID;
	
	@FindBy(xpath="//*[@id=\"ministmt\"]/tbody/tr[2]/td[2]")
	private WebElement AmmountOfLastTransaction;
	
	@FindBy(xpath="//*[@id=\"ministmt\"]/tbody/tr[2]/td[3]")
	private WebElement TypeOfLastTransaction;
	
	@FindBy(xpath="//*[@id=\"ministmt\"]/tbody/tr[2]/td[4]")
	private WebElement DateOfLastTransaction;
	
	@FindBy(xpath="//*[@id=\"ministmt\"]/tbody/tr[2]/td[5]")
	private WebElement DescOfLastTransaction;
	
	@FindBy(linkText="Continue")
	private WebElement ContinueLink;
	//*[@id="ministmt"]/tbody/tr[2]/td[1]
	
	public void ContinueClick() {
		ContinueLink.click();
	}
	
	public String getHeader() {
		return Header.getText();
	}
	
	public Map<String,String> getLastTransactionDetails() {
		
		Map<String,String> map = new HashMap<String,String>();
		
		map.put("LastTransactionID", LastTransactionID.getText());
		map.put("AmmountOfLastTransaction", AmmountOfLastTransaction.getText());
		map.put("DateOfLastTransaction", DateOfLastTransaction.getText());
		map.put("DescOfLastTransaction", DescOfLastTransaction.getText());
		map.put("TypeOfLastTransaction", TypeOfLastTransaction.getText());
		
		return map;
	}
	

}
	
