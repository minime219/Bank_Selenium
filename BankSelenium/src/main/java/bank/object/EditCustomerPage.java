package main.java.bank.object;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class EditCustomerPage {
	
	@FindBy(name="cusid")
	private WebElement CustomerIDField;
	
	@FindBy(name="AccSubmit")
	private WebElement SubmitButton;
	
	@FindBy(name="res")
	private WebElement ResetButton;
	
	@FindBy(xpath="//p[@class='heading3']")
	private WebElement Header;
	
	public void doEdit(String cusid) {
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
