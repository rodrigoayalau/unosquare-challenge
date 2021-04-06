package pages;

import org.openqa.selenium.WebDriver;

public abstract class ShopCartFlow {
	
	protected WebDriver driver;
	
	protected ShopCartFlow(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean priceValidation(String price) {
		return false;
	}
	
	public boolean deleteItem() {
		return false;
	}

}
