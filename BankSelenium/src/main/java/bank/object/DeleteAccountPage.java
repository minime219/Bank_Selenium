package main.java.bank.object;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
public class DeleteAccountPage {
	
	@FindBy(name="accountno")
	private WebElement AccountNoField;
	
	@FindBy(name="AccSubmit")
	private WebElement SubmitButton;
	
	@FindBy(name="res")
	private WebElement ResetButton;
	
	public void doDelete(String accno) {
		AccountNoField.sendKeys(accno);
		SubmitButton.click();
	}
	
}
