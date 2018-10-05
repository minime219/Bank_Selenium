package main.java.bank.object;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class EditAccountDetails {
	
	@FindBy(xpath="//p[@class='heading3']")
	private WebElement Header;
	
	@FindBy(name="txtcid")
	private WebElement CustomerIDField;
	
	@FindBy(name="txtinitdep")
	private WebElement BalanceField;
	
	@FindBy(linkText="Home")
	private WebElement HomeLink;
	
	public String getCustomerID() {
		return CustomerIDField.getAttribute("value");
	}
	
	public void homeLinkClick() {
		HomeLink.click();
	}
	
	
	public String getBalance() {
		return BalanceField.getAttribute("value");
	}
}
