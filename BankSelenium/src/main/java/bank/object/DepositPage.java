package main.java.bank.object;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class DepositPage {
	
	@FindBy(name="accountno")
	private WebElement AccountNoField;
	
	@FindBy(name="ammount")
	private WebElement AmmountField;
	
	@FindBy(xpath="//p[@class='heading3']")
	private WebElement Header;
	
	@FindBy(name="desc")
	private WebElement DescField;
	
	@FindBy(name="AccSubmit")
	private WebElement SubmitButton;
	
	@FindBy(name="res")
	private WebElement ResetButton;
	
	public void doDeposit(String accNo, String ammount, String desc) {
		AccountNoField.clear();
		AccountNoField.sendKeys(Mapping.AccID_2);
		AmmountField.clear();
		AmmountField.sendKeys(Mapping.FundTransferAmount);
		DescField.clear();
		DescField.sendKeys(Mapping.FundTransferDesc);
		SubmitButton.click();
	}
	
	public void doReset() {
		ResetButton.click();
	}
	
	public String getHeader() {
		return Header.getText();
	}
	
}
