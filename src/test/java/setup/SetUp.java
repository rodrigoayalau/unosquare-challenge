package setup;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetUp implements ISetUp{

	protected WebDriver driver = null;
	FileInputStream fileInput = null;
	String driverExplorer;

	@Override
	public void readPropertiesFile() throws IOException {
		Properties properties= new Properties();
		File file = new File("D:\\Development\\Java\\unosquare-challenge\\src\\test\\resources\\resoruces\\data.properties");
		fileInput = new FileInputStream(file);
		properties.load(fileInput);
		
	}
	
	@Override
	public WebDriver initializeChromeExplorer() {
		System.setProperty("webdriver.chrome.driver", "C:/drivers_explorers/chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}

	@Override
	public WebDriver initializeFireFoxExplorer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WebDriver initializeIEExplorer() {
		// TODO Auto-generated method stub
		return null;
	}




	
}
