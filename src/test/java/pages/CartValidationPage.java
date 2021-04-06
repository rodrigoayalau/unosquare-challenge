package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartValidationPage {
	
	WebDriver driver;
	
	@FindBy(id = "hlb-view-cart-announce")
	WebElement cartButton;

	public CartValidationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean clickCartButton() {
		boolean isSucceed;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 6);
			WebElement cartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hlb-view-cart-announce")));
			cartButton.click();
			isSucceed = true;
		} catch (Exception e) {
			e.printStackTrace();
			isSucceed = false;
		}
		return isSucceed;
	}
	
	
}
