package main.java.bank.object;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class CustomerRegisteredPage {
	
	public static String CustomerIDNo;
	
	@FindBy(xpath="//*[@class='heading3']")
	protected WebElement Header;
	
	@FindBy(xpath="//*[@id=\"customer\"]/tbody/tr[4]/td[2]")
	private WebElement CustomerID;
	
	@FindBy(linkText="Continue")
	private WebElement ContinueLink;
	
	
	public void setID() {
		CustomerIDNo = CustomerID.getText();
	}
	
	public String getHeader() {
		return Header.getText();
	}
	
	public String getID() {
		return CustomerID.getText();
	}
	
	public void continueClick() {
		ContinueLink.click();
	}
}
