package main.java.bank.object.user.pages;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.*;
public class MiniStatementPage extends PageBaseObject {
	
	@FindBy(name="accountno")
	private WebElement AccountNoField;
	
	@FindBy(name="AccSubmit")
	private WebElement SubmitButton;
	
	private WebDriver driver;
	
	public MiniStatementPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void doMiniStatement(String accNo) {
		AccountNoField.clear();
		AccountNoField.sendKeys(accNo);
		SubmitButton.click();
	}
}
