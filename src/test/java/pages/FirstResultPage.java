package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FirstResultPage {
	WebDriver driver;

	@FindBy(xpath="//span[@class='a-offscreen']")
	List<WebElement> wholePriceSpan;

	@FindBy(xpath="//span[@class='a-price']")
	List<WebElement> aWholePriceSpan;
	

	public FirstResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * I retrieve in a list of weblements all the prices shown in the dom by a
	 * classname this is for the price validator to get the first real product and
	 * its price and click on it and store it in a variable the price. Sometimes
	 * when you search for a product some ads are shown in first place.
	 */
	public String getPrice() {
		String thePrice;
		//Implicit Wait
		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			List<WebElement> priceList = new ArrayList<WebElement>();
			// Lambda function for webelements
			aWholePriceSpan.forEach((item) -> {
				priceList.add(item);
			});
			String tempPrice = priceList.get(0).getText();
			String replaceFormat = tempPrice.replace("US$", "");
			String[] fractionFormat = replaceFormat.split("\n");
			thePrice = fractionFormat[0] + "." + fractionFormat[1];
			priceList.get(0).click();
		} catch (Exception e) {
			e.printStackTrace();
			thePrice = "";
		}
		return thePrice;

	}

}
