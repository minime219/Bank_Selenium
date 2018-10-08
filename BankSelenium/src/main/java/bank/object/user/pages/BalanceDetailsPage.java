package main.java.bank.object.user.pages;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.*;

public class BalanceDetailsPage extends PageBaseObject {
	
	private WebDriver driver;
	
	@FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[6]/td[2]")
	private WebElement AccountNo;
	
	
	public BalanceDetailsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getAccNo() {
		return AccountNo.getText();
	}
}
