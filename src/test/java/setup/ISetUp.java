package setup;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

public interface ISetUp {
	
	WebDriver initializeChromeExplorer();
	
	WebDriver initializeFireFoxExplorer();
	
	WebDriver initializeIEExplorer();
	
	void readPropertiesFile() throws FileNotFoundException, IOException;

}
