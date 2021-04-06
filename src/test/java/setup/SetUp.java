package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SetUp {

	public WebDriver driver = null;

	public WebDriver initializeExplorer(String theDriver) {
		switch (theDriver) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "C:/drivers_explorers/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "ie":
			System.setProperty("webdriver.edge.driver", "C:/drivers_explorers/msedgedriver.exe");
			driver = new EdgeDriver();
			break;
		}
		return driver;
	}
}
