package main.java.bank.object;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class LogInPage {
	
//	private WebDriver driver;
	
	@FindBy(name="btnLogin")
	private WebElement LogInButton;
	@FindBy(name="btnReset")
	private WebElement ResetButton;
	
	@FindBy(name="uid")
	private WebElement IDField;
	
	@FindBy(name="password")
	private WebElement PasswordField;
	
/*	public LogInPage (WebDriver driver) {
		this.driver=driver;
	//	PageFactory.initElements(driver, this);
	} */
	
	public void doLogIn(String user, String password) {
	
		IDField.clear();
		IDField.sendKeys(user);
		PasswordField.clear();
		PasswordField.sendKeys(password);
		LogInButton.click();
		
	}
	
	public void doReset() {
		ResetButton.click();
	}

}
