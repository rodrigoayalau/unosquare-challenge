package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class ShopCartPage extends ShopCartFlow {

	WebDriver driver;

	@FindBy(xpath = "//span[@data-action='delete']//child::span[1]//child::input[1]")
	WebElement deleteLink;

	@FindBy(xpath = "//*[@id='sc-active-cart']/div/div/div[2]/div[1]/h2")
	By emptyText;

	public ShopCartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@Override
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

	@Override
	public boolean deleteItem() {
		WebDriverWait wait = new WebDriverWait(driver, 8);
		boolean isSucceed = false;
		try {
			deleteLink.click();
			WebElement emptyTextWarning = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='sc-active-cart']/div/div/div[2]/div[1]/h2")));
			emptyTextWarning.isDisplayed();
			if (emptyTextWarning.isDisplayed()) {
				isSucceed = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			isSucceed = false;
		}
		return isSucceed;
	}

}
