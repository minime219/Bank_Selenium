package main.java.bank.object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManagerPage {
	
	@FindBy(xpath="//*[@class='heading3']")
	protected WebElement ManagerWelcome;
	
	@FindBy(linkText="Change Password")
	protected WebElement ChangePasswordLink;
	
	@FindBy(linkText="New Customer")
	protected WebElement AddNewCustomerLink;
	
	@FindBy(linkText="New Account")
	protected WebElement AddNewAccountLink;
	
	@FindBy(linkText="Delete Account")
	protected WebElement DeleteAccountLink;
	
	@FindBy(linkText="Mini Statement")
	protected WebElement MiniStatementLink;
	
	@FindBy(linkText="Balance Enquiry")
	protected WebElement BalanceEnquiryLink;
	
	@FindBy(linkText="Customised Statement")
	protected WebElement CustomisedStatementLink;
	
	@FindBy(linkText="Delete Customer")
	protected WebElement DeleteCustomerLink;
	
	@FindBy(linkText="Edit Customer")
	protected WebElement EditCustomerLink;
	
	@FindBy(linkText="Fund Transfer")
	protected WebElement FundTransferLink;
	
	@FindBy(linkText="Deposit")
	protected WebElement DepositLink;
	
	@FindBy(linkText="Withdrawal")
	protected WebElement WithdrawalLink;
	
	@FindBy(linkText="Edit Account")
	protected WebElement EditAccountLink;
	
	@FindBy(linkText="Log out")
	protected WebElement LogOutLink;
	
	public void logOutLinkClick() {
		LogOutLink.click();
	}
	
	public void editAccountClick() {
		EditAccountLink.click();
	}
	
	public void withdrawalLinkClick() {
		WithdrawalLink.click();
	}
	
	public void depositClick() {
		DepositLink.click();
	}
	
	public void fundTransferClick() {
		FundTransferLink.click();
	}
	
	public void editCustomerClick() {
		EditCustomerLink.click();
	}
	
	public void deleteCustomerClick() {
		DeleteCustomerLink.click();
	}
	
	public void customisedStatementClick() {
		CustomisedStatementLink.click();
	}
	
	public void balanceEnquiryClick() {
		BalanceEnquiryLink.click();
	}
	
	public void miniStatementClick() {
		MiniStatementLink.click();
	}
	
	public String getManageWelcomeText() {
		return ManagerWelcome.getText();
	}
	
	public void changePassword() {
		ChangePasswordLink.click();
	}
	
	public void addNewCustomer() {
		AddNewCustomerLink.click();
	}
	
	public void addNewAccount() {
		AddNewAccountLink.click();
	}
	
	public void deleteAccount() {
		DeleteAccountLink.click();
	}

}
