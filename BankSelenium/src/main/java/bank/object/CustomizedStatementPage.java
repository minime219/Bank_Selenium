package main.java.bank.object;
import org.openqa.selenium.support.*;
import org.openqa.selenium.WebElement;

public class CustomizedStatementPage {
	@FindBy(name="accountno")
	private WebElement AccountNoField;
	
	@FindBy(name="AccSubmit")
	private WebElement SubmitButton;
	
	@FindBy(name="res")
	private WebElement ResetButton;
	
	@FindBy(xpath="//p[@class='heading3']")
	private WebElement Header;
	
	@FindBy(name="fdate")
	private WebElement FromDateField;
	
	@FindBy(name="tdate")
	private WebElement ToDateField;
	
	@FindBy(name="numtransaction")
	private WebElement NumberOfTransactionField;
	
	public String getHeader() {
		return Header.getText();
	}
	
	public void doCustomized(String accNo) {
		AccountNoField.sendKeys(accNo);
		SubmitButton.click();
	}
	
	public void doCustomizedWithAll(String accNo,String fromDate,String toDate, String noOfTran) {
		AccountNoField.clear();
		AccountNoField.sendKeys(accNo);
		FromDateField.sendKeys(fromDate);
		ToDateField.sendKeys(toDate);
		NumberOfTransactionField.clear();
		NumberOfTransactionField.sendKeys(noOfTran);
		SubmitButton.click();
	}
	
	public void doReset() {
		ResetButton.click();
	}
	
	
}
