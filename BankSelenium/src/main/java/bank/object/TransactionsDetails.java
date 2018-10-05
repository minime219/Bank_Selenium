package main.java.bank.object;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class TransactionsDetails {
	
	@FindBy(xpath="//p[@class='heading3']")
	private WebElement Header;
	
	@FindBy(xpath="//*[@id=\"customstmt\"]/tbody/tr[1]/th")
	private List<WebElement> col;
	
	@FindBy(xpath="//*[@id=\"customstmt\"]/tbody/tr/td[1]")
	private List<WebElement> row;
	
	@FindBy(linkText="Continue")
	private WebElement ContinueLink;
	
	@FindBy(xpath="//*[@id=\"customstmt\"]/tbody/tr[2]/td[1]")
	private WebElement TransactionIDLatest;
	
	@FindBy(xpath="//*[@id=\"customstmt\"]/tbody/tr[2]/td[2]")
	private WebElement AmountLatestTransaction;
	
	@FindBy(xpath="//*[@id=\"customstmt\"]/tbody/tr[2]/td[3]")
	private WebElement TypeLastestTransaction;
	
	private WebDriver driver;
	private String xpathOfFirstPath = "//*[@id=\"customstmt\"]/tbody/tr[";
	private String xpathOfTransactionID = "]/td[1]";
	private String xpathOfType = "]/td[3]";
	private String xpathOfAmount = "]/td[2]";
	private String xpathOfDate = "]/td[4]";
	private String xpathOfDesc = "]/td[5]";
	
	public TransactionsDetails(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
			
	//*[@id="customstmt"]/tbody/tr[5]/td[2]
	//*[@id="customstmt"]/tbody/tr[1]/th[1]
	
	public String getNoOfRow() {
		return Integer.toString(row.size());
	}
	public String getNoofCol() {
		return Integer.toString(col.size());
	}
	
	public String getLastTransactionID() {
		return driver.findElement(By.xpath(xpathOfFirstPath+getNoOfRow()+xpathOfTransactionID)).getText();
	}
	
	public String getAmountOfLastTransaction() {
		return driver.findElement(By.xpath(xpathOfFirstPath+getNoOfRow()+xpathOfAmount)).getText();
	}
	
	public String getTypeOfLastTransaction() {
		return driver.findElement(By.xpath(xpathOfFirstPath+getNoOfRow()+xpathOfType)).getText();

	}
	
	public String getDateOfLastTransaction() {
		return driver.findElement(By.xpath(xpathOfFirstPath+getNoOfRow()+xpathOfDate)).getText();

	}
	
	public String getDescofLastTransaction() {
		return driver.findElement(By.xpath(xpathOfFirstPath+getNoOfRow()+xpathOfDesc)).getText();

	}
	
	public String getHeader() {
		return Header.getText();
	}
	
	public void continueClick() {
		ContinueLink.click();
	}
	
	
}
