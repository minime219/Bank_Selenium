package main.java.bank.object.user.pages;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.*;

public class FundTransferPage extends PageBaseObject {
	
	@FindBy(name="payersaccount")
	private WebElement PayersAccField;
	
	@FindBy(name="payeeaccount")
	private WebElement PayeeAccField;
	
	@FindBy(name="ammount")
	private WebElement AmmountField;
	
	@FindBy(name="desc")
	private WebElement DescField;
	
	@FindBy(name="AccSubmit")
	private WebElement SubmitButton;

	private WebDriver driver;
	
	public FundTransferPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void doFundTransfer(String payerAcc, String payeeAcc, String ammount, String desc) {
		PayersAccField.clear();
		PayersAccField.sendKeys(payerAcc);
		PayeeAccField.clear();
		PayeeAccField.sendKeys(payeeAcc);
		AmmountField.clear();
		AmmountField.sendKeys(ammount);
		DescField.clear();
		DescField.sendKeys(desc);
		SubmitButton.click();
	}
}
