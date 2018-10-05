package main.java.bank.object;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.Select;
public class AddNewAccountPage {
	@FindBy(name="cusid")
	private WebElement CustomerIDField;
	
	@FindBy(name="selaccount")
	private WebElement SelectAccountTyp;
	
	@FindBy(name="inideposit")
	private WebElement IniDepositField;
	
	@FindBy(name="button2")
	private WebElement SubmitButton;
	
	@FindBy(name="reset")
	private WebElement ResetButton;
	
	public void doAddNewAccount(String cusid, String accounttyp, String inideposit) {
		CustomerIDField.clear();
		CustomerIDField.sendKeys(cusid);
		
		Select dropdwn = new Select(SelectAccountTyp);
		dropdwn.selectByValue(accounttyp);
		
		IniDepositField.clear();
		IniDepositField.sendKeys(inideposit);
		
		SubmitButton.click();
		
	}
	
	public void doReset() {
		ResetButton.click();
	}
}
