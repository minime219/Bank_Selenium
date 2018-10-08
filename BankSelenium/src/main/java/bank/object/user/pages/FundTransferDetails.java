package main.java.bank.object.user.pages;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.*;

public class FundTransferDetails {

	@FindBy(xpath="/html/body/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]")
	private WebElement FromAccField;
	
	@FindBy(xpath="/html/body/table/tbody/tr[2]/td/table/tbody/tr[4]/td[2]")
	private WebElement ToAccField;
	
	@FindBy(linkText="Continue")
	private WebElement ContinueLink;
	
	private WebDriver driver;
	
	public FundTransferDetails(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getFromAcc() {
		return FromAccField.getText();
	}
	
	public String getToAcc() {
		return ToAccField.getText();
	}
	
	public void continueClick() {
		ContinueLink.click();
	}
}
