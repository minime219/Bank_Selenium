package main.java.bank.object;
import org.openqa.selenium.support.*;
import org.openqa.selenium.*;

public class WithdrawalPage {
	
	@FindBy(xpath="//p[@class='heading3']")
	private WebElement Header;
	
	@FindBy(name="accountno")
	private WebElement AccountIDField;
	
	@FindBy(name="ammount")
	private WebElement AmmountField;
	
	@FindBy(name="desc")
	private WebElement DescField;
	
	@FindBy(name="AccSubmit")
	private WebElement SubmitButton;
	
	@FindBy(name="res")
	private WebElement ResetButton;
	
	public String getHeader() {
		return Header.getText();
	}
	
	public void doWithdrawal(String accNo, String ammount, String desc) {
		AccountIDField.clear();
		AccountIDField.sendKeys(accNo);
		AmmountField.clear();
		AmmountField.sendKeys(ammount);
		DescField.clear();
		DescField.sendKeys(desc);
		SubmitButton.click();
	}
}
