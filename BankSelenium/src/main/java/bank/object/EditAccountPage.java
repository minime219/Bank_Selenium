package main.java.bank.object;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class EditAccountPage {
	
	@FindBy(xpath="//p[@class='heading3']")
	private WebElement Header;
	
	@FindBy(name="accountno")
	private WebElement AccountNoField;
	
	@FindBy(name="AccSubmit")
	private WebElement SubmitButton;
	
	@FindBy(name="res")
	private WebElement ResetButton;
	
	public String getHeader() {
		return Header.getText();
		
	}
	
	public void doEditAcc(String accNo) {
		AccountNoField.clear();
		AccountNoField.sendKeys(accNo);
		SubmitButton.click();
	}

}
