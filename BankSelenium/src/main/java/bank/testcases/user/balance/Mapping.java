package main.java.bank.testcases.user.balance;

public class Mapping {
	public static String LogInURL = "http://www.demo.guru99.com/V4/index.php";
	public static String User = "8065";
	public static String Password = "123456_7";
	public static String AccID = "49906";
	public static String BalanceEnquiryURL = "http://www.demo.guru99.com/V4/customer/BalEnqInput.php";
	public static String BalanceDetailsURL = "http://www.demo.guru99.com/V4/customer/BalEnquiry.php";
	public static String BalanceDetailsHeader = "Balance Details for Account ";
	public static String ScreenshotFilePath = System.getProperty("user.dir")+"\\src\\main\\java\\bank\\testcases\\user\\balance\\screenshots\\Test_Balance_Enquiry_Page_";
	public static String PayeeAcc = "49908";
	public static String Ammount = "10";
	public static String Desc = "fund";
	public static String ScreenshotFunTransferFilePath = System.getProperty("user.dir")+"\\src\\main\\java\\bank\\testcases\\user\\funtransfer\\screenshots\\Test_Fund_Transfer_Page_";
	public static String FundTransferURL = "http://www.demo.guru99.com/V4/customer/customerfundinput.php";
	public static String ScreenshotCustStatementFilePath = System.getProperty("user.dir")+"\\src\\main\\java\\bank\\testcases\\user\\custstatement\\screenshots\\Test_Fund_Transfer_Page_";
	public static String NotAuthorizeAccount = "You are not authorize to Transfer Funds from this account!!";
	public static String AccNotExist = "9999999";
	public static String AccNotExistAlert = "Account 9999999does not exist!!!";
	public static String TransferSameAccAlert = "Payers account No and Payees account No Must Not be Same!!!";
	public static String StatementWrongAccAlert = "You are not authorize to generate statement of this Account!!";
	public static String StatementNotExistAccAlert = "Account does not exist";
	public static String NoOfTrans = "30";
	public static String StatementWrongDateInputAlert = "FromDate field should be lower than ToDate field!!";
}
