package main.java.bank.object;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
public class MiniStatementPage {
	
	@FindBy(name="accountno")
	private WebElement AccountNoField;
	
	@FindBy(name="AccSubmit")
	private WebElement SubmitButton;
	
	@FindBy(name="res")
	private WebElement ResetButton;
	
	@FindBy(xpath="//*[@class='heading3']")
	private WebElement Header;
	
	public void doStatement(String accno) {
		AccountNoField.clear();
		AccountNoField.sendKeys(accno);
		SubmitButton.click();
	}
	
	public String getHeader() {
		return Header.getText();
	}

}
