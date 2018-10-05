package main.java.bank.object;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
public class FundTransferPage {
	
	@FindBy(xpath="//p[@class='heading3']")
	private WebElement Header;
	
	@FindBy(name="payersaccount")
	private WebElement PayersAccField;
	
	@FindBy(name="payeeaccount")
	private WebElement PayeeAccField;
	
	@FindBy(name="ammount")
	private WebElement AmountField;
	
	@FindBy(name="desc")
	private WebElement DescField;
	
	@FindBy(name="AccSubmit")
	private WebElement SubmitButton;
	
	@FindBy(name="res")
	private WebElement ResetButton;
	
	public void doTransfer(String payerAcc, String payeeAcc, String amount, String desc) {
		PayersAccField.clear();
		PayersAccField.sendKeys(payerAcc);
		
		PayeeAccField.clear();
		PayeeAccField.sendKeys(payeeAcc);
		
		AmountField.clear();
		AmountField.sendKeys(amount);
		
		DescField.clear();
		DescField.sendKeys(desc);
		
		SubmitButton.click();
		
	}
	
	public void doReset() {
		ResetButton.click();
		
	}
	
	public String getHeader() {
		return Header.getText();
	}

}
