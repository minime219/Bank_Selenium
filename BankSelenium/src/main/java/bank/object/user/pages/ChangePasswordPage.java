package main.java.bank.object.user.pages;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.*;

public class ChangePasswordPage extends PageBaseObject {
	
	private WebDriver driver;
	
	@FindBy(name="oldpassword")
	private WebElement OldPasswordField;
	
	@FindBy(name="newpassword")
	private WebElement NewPasswordField;
	
	@FindBy(name="confirmpassword")
	private WebElement ConfirmPasswordField;
	
	public ChangePasswordPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void doChangePassword(String oldPassword, String newPassword, String confirmPassword) {
		OldPasswordField.clear();
		OldPasswordField.sendKeys(oldPassword);
		NewPasswordField.clear();
		NewPasswordField.sendKeys(newPassword);
		ConfirmPasswordField.clear();
		ConfirmPasswordField.sendKeys(confirmPassword);
		clickSubmitButton();
	}
	
}
