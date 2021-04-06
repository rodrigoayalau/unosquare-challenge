package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class SetUp {
	
	public WebDriver driver = null;
	
	public WebDriver initializeExplorer() {
		System.setProperty("webdriver.chrome.driver", "C:/drivers_explorers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/-/es/ref=nav_logo");
		driver.manage().window().maximize();
		return driver;
	}
}
