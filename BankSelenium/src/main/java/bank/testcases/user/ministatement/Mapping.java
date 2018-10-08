package main.java.bank.testcases.user.ministatement;

public class Mapping {
	public static String LogInURL = "http://www.demo.guru99.com/V4/index.php";
	public static String User = "52379";
	public static String Password = "123456_7";
	public static String AccID = "49656";
	public static String ScreenshotFilePath = System.getProperty("user.dir")+"\\src\\main\\java\\bank\\testcases\\user\\ministatement\\screenshots\\Test_Mini_Statement_Page_";
	public static String WrongAccID = "49456";
	public static String WrongAccNoAlert = "You are not authorize to generate statement of this Account!!";
	public static String NonExistAccNo = "9999999";
	public static String NonExistAccAlert = "Account does not exist";
	public static String StatementInputURL = "http://www.demo.guru99.com/V4/customer/MiniStatementInput.php";
}
