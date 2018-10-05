package main.java.bank.object;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class BalanceEnquiryPage {
	
	@FindBy(name="accountno")
	private WebElement AccountNoField;
	
	@FindBy(xpath="//p[@class='heading3']")
	private WebElement Header;
	
	@FindBy(name="AccSubmit")
	private WebElement SubmitButton;
	
	@FindBy(name="res")
	private WebElement ResetButton;
	
	@FindBy(linkText="Home")
	private WebElement HomeLink;
	
	public void doEnquiry(String accountno) {
		AccountNoField.clear();
		AccountNoField.sendKeys(accountno);
		SubmitButton.click();
	}
	
	public void doReset() {
		ResetButton.click();
	}
	
	public String getHeader() {
		return Header.getText();
	}
	
	public void homeLinkClick() {
		HomeLink.click();
	}
}
