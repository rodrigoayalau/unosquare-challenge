package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import setup.KeyPad;

public class HelpCustomerServicePage extends KeyPad{
	
	WebDriver driver = null;
	
	@FindBy(id="helpsearch")
	WebElement helpSearchInput;
	
	public HelpCustomerServicePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public boolean searchInInput(String searchCriteria) {
		boolean isSucceed;
		try {
			helpSearchInput.clear();
			helpSearchInput.sendKeys(searchCriteria);
			clickEnter(helpSearchInput);
			isSucceed = true;
		} catch (Exception e) {
			e.printStackTrace();
			isSucceed = false;
		}
		return isSucceed;
	}
	
	
	
}
