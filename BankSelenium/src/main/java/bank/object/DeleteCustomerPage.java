package main.java.bank.object;
import org.openqa.selenium.support.*;
import org.openqa.selenium.*;
public class DeleteCustomerPage {
	
	@FindBy(name="cusid")
	private WebElement CustomerIDField;
	
	@FindBy(xpath="//p[@class='heading3']")
	private WebElement Header;
	
	@FindBy(name="AccSubmit")
	private WebElement SubmitButton;
	
	@FindBy(name="res")
	private WebElement ResetButton;
	
	
	public void doDelete(String cusid) {
		CustomerIDField.clear();
		CustomerIDField.sendKeys(cusid);
		SubmitButton.click();
	}
	
	public void doReset() {
		ResetButton.click();
	}
	
	public String getHeader() {
		return Header.getText();
	}
	
}
