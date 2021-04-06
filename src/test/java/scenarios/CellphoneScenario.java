package scenarios;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CartValidationPage;
import pages.FirstResultPage;
import pages.ProductPage;
import pages.SearchMainPage;
import pages.ShopCartPage;
import setup.SetUp;

//Interface implemented for SetUp class
public class CellphoneScenario extends SetUp{

	String pricePhone;
	FileInputStream fileInput = null;
	String cellphoneType;
	String driverExplorer;
	String url;
	
	@BeforeClass(enabled=true)
	public void setUp() throws IOException {
		Properties properties= new Properties();
		File file = new File("D:\\Development\\Java\\unosquare-challenge\\src\\test\\resources\\resoruces\\data.properties");
		fileInput = new FileInputStream(file);
		properties.load(fileInput);
		// data.properties file implemented to store any kind of data
		this.driverExplorer = properties.getProperty("driverExplorer");
		this.cellphoneType = properties.getProperty("cellphone");
		this.url = properties.getProperty("url");
		initializeChromeExplorer();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	//2. Search for Samsung Galaxy Note 20.
	@Test(priority=1, enabled=true)
	public void phoneSearch() {
		SearchMainPage searchPage = new SearchMainPage(driver);
		try {
			Assert.assertTrue(searchPage.searchCriteria(cellphoneType), "Failed trying to search criteria.");
			Assert.assertTrue(searchPage.clickButtonSearch(), "Failed trying to click search button.");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 3. Verify Item is displayed on the screen and  locate the first one, then store the price.
	// 4. Click on the First Result.
	@Test(priority=2, enabled=true)
	public void getPrice() {
		FirstResultPage resultPage = new FirstResultPage(driver);
		try {
			this.pricePhone = resultPage.getPrice();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 5. Once in the details page compare this price vs the above one (first stored price).
	@Test(priority=3, enabled=true)
	public void validatePrices() {
		ProductPage galaxyPage = new ProductPage(driver);
		try {
			Assert.assertTrue(galaxyPage.priceValidator(pricePhone), "Prices do not match.");
			Assert.assertTrue(galaxyPage.addToCart(), "Failed trying to add item to cart.");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 6. Click on Add to Cart.
	@Test(priority=4, enabled=true)
	public void clickCartButton() {
		CartValidationPage validateItem = new CartValidationPage(driver);
		try {
			Assert.assertTrue(validateItem.clickCartButton(), "Failed trying to click cart button.");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 7. Go to Cart and verify again the price of the phone.
	// 8. Delete Item.
	@Test(priority= 5, enabled=true)
	public void shopCartPageValidation() {
		ShopCartPage validateItem = new ShopCartPage(driver);
		try {
			Assert.assertTrue(validateItem.priceValidation(pricePhone), "Prices do not match.");
			Assert.assertTrue(validateItem.deleteItem(), "Failed trying to delete item in cart.");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@AfterClass(enabled=true)
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
