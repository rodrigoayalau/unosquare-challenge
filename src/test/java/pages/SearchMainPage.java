package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchMainPage {
	
	WebDriver driver = null;
	
	/*Some ways to reach web elements.
	 * Page Factory used in this example
	*/
	
	private static final By INPUT_FIELD = By.id("twotabsearchtextbox");
	
	@FindBy(id="twotabsearchtextbox")
	WebElement inputField;
	
	@FindBy(id="nav-search-submit-button")
	WebElement searchButton;
	
		
	public SearchMainPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean searchCriteria(String criteria) {
		boolean isSucceed;
		WebDriverWait wait = new WebDriverWait(driver, 6);
		try {
			WebElement inputFieldtext = driver.findElement(INPUT_FIELD);
			WebElement alertShipping = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='nav-main']/div[1]/div")));
			if(alertShipping.isDisplayed()) {
				WebElement continueButton = driver.findElement(By.xpath("//*[@id='nav-main']/div[1]/div/div/div[3]/span[1]/span/input"));
				continueButton.click();
			}
			inputFieldtext.sendKeys(criteria);
			isSucceed = true;
		} catch(Exception e) {
			e.printStackTrace();
			isSucceed = false;
		}
		return isSucceed;
	}
	
	public boolean clickButtonSearch() {
		boolean isSucceed;
		try {
			searchButton.click();
			isSucceed = true;
		} catch(Exception e) {
			e.printStackTrace();
			isSucceed = false;
		}
		return isSucceed;
	}
}
