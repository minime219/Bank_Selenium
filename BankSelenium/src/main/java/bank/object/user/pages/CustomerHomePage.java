package main.java.bank.object.user.pages;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.*;

public class CustomerHomePage extends PageBaseObject {
	
	private WebDriver driver;
	public CustomerHomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Changepassword")
	private WebElement ChangePasswordLink;
	
	@FindBy(linkText="Balance Enquiry")
	private WebElement BalanceEnquiryLink;
	
	@FindBy(linkText="Mini Statement")
	private WebElement MiniStatementLink;
	
	public void miniStatementLinkClick() {
		MiniStatementLink.click();
	}
	
	public void balanceEnquiryClick() {
		BalanceEnquiryLink.click();
	}
	
	public void changePasswordLinkClick() {
		ChangePasswordLink.click();
	}
	
}
