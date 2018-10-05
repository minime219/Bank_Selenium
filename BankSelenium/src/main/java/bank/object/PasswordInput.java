package main.java.bank.object;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class PasswordInput {
	
	@FindBy(name="oldpassword")
	private WebElement OldPasswordField;
	@FindBy(name="newpassword")
	private WebElement NewPasswordField;
	@FindBy(name="confirmpassword")
	private WebElement ConfirmPasswordField;
	@FindBy(name="sub")
	private WebElement SubmitButton;
	@FindBy(name="res")
	private WebElement ResetButton;
	@FindBy(xpath="//*[@class='heading3']")
	private WebElement Header;
	
	
	public void doChangePassword(String oldpassword, String newpassword, String confirmpassword) {
		OldPasswordField.clear();
		OldPasswordField.sendKeys(oldpassword);
		NewPasswordField.clear();
		NewPasswordField.sendKeys(newpassword);
		ConfirmPasswordField.clear();
		ConfirmPasswordField.sendKeys(newpassword);
		SubmitButton.click();
	}
	
	public void doReset() {
		ResetButton.click();
	}
	
	public String getHeader() {
		String header = Header.getText();
		return header;
	}

}
