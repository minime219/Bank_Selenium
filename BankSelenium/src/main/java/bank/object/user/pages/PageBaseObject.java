package main.java.bank.object.user.pages;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.*;

public class PageBaseObject {
	
	@FindBy(xpath="//*[@class='heading3']")
	protected WebElement Header;
	
	@FindBy(name="sub")
	protected WebElement SubmitButton;
	
	@FindBy(name="res")
	protected WebElement ResetButton;
	
	public String getHeader() {
		return Header.getText();
	}
	
	public void clickSubmitButton() {
		SubmitButton.click();
	}
	
	public void clickResetButton() {
		ResetButton.click();
	}
}
