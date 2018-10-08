package main.java.bank.object.user.pages;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.*;

public class BalanceEnquiryPage extends PageBaseObject {
	private WebDriver driver;
	
	@FindBy(name="accountno")
	private WebElement AccountType;
	
	@FindBy(name="AccSubmit")
	private WebElement SubmitButton;
	
	public BalanceEnquiryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void doEnquiry(String accNo) {
		Select accType = new Select(AccountType);
		accType.selectByVisibleText(accNo);
		SubmitButton.click();
	}
}
