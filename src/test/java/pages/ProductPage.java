package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class ProductPage {

	WebDriver driver;

	@FindBy(id = "priceblock_ourprice")
	WebElement priceSpan;

	@FindBy(id = "add-to-cart-button")
	WebElement addToCartButton;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean priceValidator(String price) {
		boolean isSucceed;
		try {
			String priceText = priceSpan.getText();
			String[] priceNumber = priceText.split(" ");
			String justPrice = priceNumber[1];
			Assert.assertEquals(price, justPrice);
			isSucceed = true;
		} catch (Exception e) {
			e.printStackTrace();
			isSucceed = false;
		}
		return isSucceed;
	}

	public boolean addToCart() {
		boolean isSucceed;
		try {
			addToCartButton.click();
			isSucceed = true;
		} catch (Exception e) {
			e.printStackTrace();
			isSucceed = false;
		}
		return isSucceed;
	}

}
