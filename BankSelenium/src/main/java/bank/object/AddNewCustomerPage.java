package main.java.bank.object;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddNewCustomerPage {
	
	@FindBy(name="name")
	private static WebElement CustomerNameField;
	
	@FindBy(xpath="//input[@name='rad1' and @value='m']")
	private static WebElement MaleRadioButton;
	
	@FindBy(xpath="//input[@value='f']")
	private static WebElement FemaleRadioButton;
	
	@FindBy(id="dob")
	private static WebElement BirthdayField;
	
	@FindBy(name="addr")
	private static WebElement AddressField;
	
	@FindBy(name="city")
	private static WebElement CityField;
	
	@FindBy(name="state")
	private static WebElement StateField;
	
	@FindBy(name="pinno")
	private static WebElement PinField;
	
	@FindBy(name="telephoneno")
	private static WebElement TelField;
	
	@FindBy(name="emailid")
	private static WebElement EmailField;
	
	@FindBy(name="password")
	private static WebElement PasswordField;
	
	@FindBy(name="sub")
	private static WebElement SubmitButton;
	
	@FindBy(name="res")
	private static WebElement ResetButton;
	
	public void doAddCustomer(String name, String gender, String birthday, String address, String city, String state, String pin, String mobile, String email, String password) {
		CustomerNameField.clear();
		CustomerNameField.sendKeys(name);
		
		switch (gender) {
		case "male": 
			if (!MaleRadioButton.isSelected()) MaleRadioButton.click();
			break;
		case "female":
			if (!FemaleRadioButton.isSelected()) FemaleRadioButton.click();
			break;
		default: 
			System.out.println("Not a Gender");
			break;
		}
		
	//	BirthdayField.clear();
		BirthdayField.sendKeys(birthday);
		
		AddressField.clear();
		AddressField.sendKeys(address);
		
		CityField.clear();
		CityField.sendKeys(city);
		
		StateField.clear();
		StateField.sendKeys(state);
		
		PinField.clear();
		PinField.sendKeys(pin);
		
		TelField.clear();
		TelField.sendKeys(mobile);
		
		EmailField.clear();
		EmailField.sendKeys(email);
		
		PasswordField.clear();
		PasswordField.sendKeys(password);
		
		SubmitButton.click();
		
	}
	
	public void doReset() {
		ResetButton.click();
	}

}
