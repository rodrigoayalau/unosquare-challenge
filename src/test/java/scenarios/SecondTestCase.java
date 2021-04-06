package scenarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CreateAccountPage;
import pages.HelpCustomerServicePage;
import pages.SearchMainPage;
import pages.SignInPage;
import services.JsonService;
import setup.SetUp;

public class SecondTestCase extends SetUp {
	
	/*
	 *  *********************************************
	 *  IN THE MEHTOD newAccountDetailsAndTermsConditions()
	 *  (I crated a json service to retrieve the data)
	 *  SOMETIMES THE SERVICE GETS A 429 CODE AND IT CANT
	 *  GET THE DATA FROM THE JSON, THE SERVICES SHOWS A
	 *  'TOO MANY REQUES IN THE BROWSER' RE RUN IT OR change
	 *  the employee_name for the explicit way.
	 *  **********************************************
	 */

	FileInputStream fileInput = null;
	String driverExplorer;
	String url;
	String accountName;
	String accountEmail;
	String searchCriteria;
	String supportLink;
	String supportItem1;
	String supportItem2;
	String supportItem3;
	String supportItem4;
	String supportItem5;
	String DBCoonection;

	@BeforeClass(enabled = true)
	public void setUp() throws IOException {
		Properties properties = new Properties();
		File file = new File(
				"D:\\Development\\Java\\unosquare-challenge\\src\\test\\resources\\resoruces\\data.properties");
		fileInput = new FileInputStream(file);
		properties.load(fileInput);
		// data.properties file implemented to store any kind of data
		this.DBCoonection = properties.getProperty("dbconnection");
		if(this.DBCoonection == "PROD_URL") {
			this.driverExplorer = properties.getProperty("driverExplorer");
			this.url = properties.getProperty("url");
			this.searchCriteria = properties.getProperty("searchCriteria");
			this.supportLink = properties.getProperty("supportLink");
			this.supportItem1 = properties.getProperty("supportItem1");
			this.supportItem2 = properties.getProperty("supportItem2");
			this.supportItem3 = properties.getProperty("supportItem3");
			this.supportItem4 = properties.getProperty("supportItem4");
			this.supportItem5 = properties.getProperty("supportItem5");
			initializeChromeExplorer();
			driver.get(url);
			driver.manage().window().maximize();			
		} else {
			//System.out.println("Value of DBConnection is incorrect.");
		}
	}

	// 2. Locate at the upper right corner the button: Hello, Sign In Account &
	// lists and click on it.
	@Test(priority = 1, enabled = true)
	public void newAccounts() {
		SearchMainPage linkAccount = new SearchMainPage(driver);
		try {
			Assert.assertTrue(linkAccount.clickAccountSignIn(), "Failed trying to click on signin.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 3. Click on "New customer? Start right here".
	@Test(priority = 2, enabled = true)
	public void newCustomerLink() {
		SignInPage signin = new SignInPage(driver);
		try {
			Assert.assertTrue(signin.clickNewAccount(), "Failed trying to click on new account.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 4. Fill Name field with the response of this API => [Options in the AC].
	// **** Warning, sometimes this test could fail due a 429 while requesting the json from url
	// 5. Fill Email field with the data from the API response Firstname.Lastname@fake.com
	// 6. Click on Condition of Use link
	@Test(priority = 3, enabled = true)
	public void newAccountDetailsAndTermsConditions() {
		JsonService jsonDetails = new JsonService();
		try {
			this.accountName = jsonDetails.getDetails();
			this.accountEmail = jsonDetails.employee_email;
			CreateAccountPage createAccount = new CreateAccountPage(driver);
			Assert.assertTrue(createAccount.setAccountDetails(accountName, accountEmail), "Failed trying to create account.");
			Assert.assertTrue(createAccount.clickConditionUse(), "Failed trying to click terms and conditions.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 7. Locate the search bar and Search for Echo
	// 8. Locate "Echo support" options and click on it
	@Test(priority = 4, enabled = true)
	public void searchCriteria() {
		HelpCustomerServicePage search = new HelpCustomerServicePage(driver);
		try {
			// Explicit wait in the method
			Assert.assertTrue(search.searchInInput(searchCriteria), "Failed trying to search.");
			Assert.assertTrue(search.seachCustomerLink(supportLink), "Failed trying to click link.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 9. Following elements should be displayed: Getting Started, Wi-Fi and Bluetooth, Device Software and Hardware, TroubleShooting 
	@Test(priority = 5, enabled = true)
	public void validateEchoSupport() {
		HelpCustomerServicePage echoSupport = new HelpCustomerServicePage(driver);
		try {
			//To compare to list one given and other one retrieved, I use a equals() method to validate and compare thw two lists.
			Assert.assertTrue(echoSupport.validateResults(supportItem1, supportItem2, supportItem3, supportItem4, supportItem5), "Failed trying to validate results.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@AfterClass(enabled = true)
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
