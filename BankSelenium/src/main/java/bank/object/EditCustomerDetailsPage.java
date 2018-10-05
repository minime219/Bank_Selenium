package main.java.bank.object;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class EditCustomerDetailsPage {
	
	@FindBy(name="name")
	private WebElement NameField;
	
	@FindBy(name="gender")
	private WebElement GenderField;
	
	@FindBy(name="dob")
	private WebElement DateOfBirthField;
	
	@FindBy(name="addr")
	private WebElement AddressField;
	
	@FindBy(name="city")
	private WebElement CityField;
	
	@FindBy(name="state")
	private WebElement StateField;
	
	@FindBy(name="pinno")
	private WebElement PinField;
	
	@FindBy(name="telephoneno")
	private WebElement MobileField;
	
	@FindBy(name="emailid")
	private WebElement EmailField;
	
	@FindBy(name="sub")
	private WebElement SubmitButton;
	
	@FindBy(name="res")
	private WebElement ResetButton;
	
	public Map<String,String> getCustomerDetails(){
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("name", NameField.getAttribute("value"));
	//	System.out.println(map.get("name"));
		map.put("gender", GenderField.getAttribute("value"));
		map.put("dob", DateOfBirthField.getAttribute("value"));
		map.put("addr", AddressField.getAttribute("value"));
		map.put("city", CityField.getAttribute("value"));
		map.put("state", StateField.getAttribute("value"));
		map.put("pin", PinField.getAttribute("value"));
		map.put("mobile", MobileField.getAttribute("value"));
		map.put("email", EmailField.getAttribute("value"));
		
		return map;
	}
	
	
}
