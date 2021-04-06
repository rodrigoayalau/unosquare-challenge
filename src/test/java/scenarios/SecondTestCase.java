package scenarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CreateAccountPage;
import pages.HelpCustomerServicePage;
import pages.SearchMainPage;
import pages.SignInPage;
import services.JsonService;
import setup.KeyPad;
import setup.SetUp;

public class SecondTestCase extends SetUp {

	FileInputStream fileInput = null;
	String driverExplorer;
	String url;
	String accountName;
	String accountEmail;
	String searchCriteria;

	@BeforeClass(enabled = true)
	public void setUp() throws IOException {
		Properties properties = new Properties();
		File file = new File(
				"D:\\Development\\Java\\unosquare-challenge\\src\\test\\resources\\resoruces\\data.properties");
		fileInput = new FileInputStream(file);
		properties.load(fileInput);
		// data.properties file implemented to store any kind of data
		this.driverExplorer = properties.getProperty("driverExplorer");
		this.url = properties.getProperty("url");
		this.searchCriteria = properties.getProperty("searchCriteria");
		initializeChromeExplorer();
		driver.get(url);
		driver.manage().window().maximize();
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
	// Warning, sometimes this test could fail due a 429 while requesting the json from url
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
	@Test(priority = 3, enabled = true)
	public void searchCriteria() {
		HelpCustomerServicePage search = new HelpCustomerServicePage(driver);
		KeyPad keypad = new KeyPad(driver);
		try {
			Assert.assertTrue(search.searchInInput(searchCriteria), "failed trying to search.");
			//Assert.assertTrue(keypad.clickEnter(), "Failed trying to click enter.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
