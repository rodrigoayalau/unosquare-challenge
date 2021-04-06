package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class ShopCartPage {
	
	WebDriver driver;
	@FindBy(xpath = "//span[@data-action='delete']//child::span[1]//child::input[1]")
	WebElement deleteItem;	
	
	public ShopCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean priceValidation(String price) {
		boolean isSucceed;
		try {
			WebElement priceSpan = driver.findElement(By.xpath("//span[contains(text(),'" + price + "')]"));
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
	
	public boolean deleteItem() {
		boolean isSucceed;
		try{
			deleteItem.click();
			isSucceed = true;
		} catch (Exception e) {
			e.printStackTrace();
			isSucceed = false;
		}
		return isSucceed;
	}

}
