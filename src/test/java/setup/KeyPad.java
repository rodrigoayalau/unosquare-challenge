package setup;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class KeyPad {
	
	WebDriver driver = null;
	
	protected final By ENTER_BUTTON = By.name("enter");
	
	public KeyPad(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean clickEnter(WebElement By) {
		boolean isSucceed;
		try {
			By.sendKeys(Keys.ENTER);
			isSucceed = true;
		} catch (Exception e) {
			e.printStackTrace();
			isSucceed = false;
		}
		return isSucceed;
	}

}
