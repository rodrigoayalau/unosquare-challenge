package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import setup.KeyPad;

public class HelpCustomerServicePage extends KeyPad{
	
	WebDriver driver = null;
	
	@FindBy(id="helpsearch")
	WebElement helpSearchInput;
	
	@FindBy(className="a-link-normal")
	List<WebElement> linkForCustomerSupport;
	
	@FindBy(xpath="//a[contains(text(), 'Echo Support')]")
	WebElement linkForEchoSupport;
	
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
	
	public boolean seachCustomerLink(String linktoSearch) {
		boolean isSucceed;
//		List<WebElement> links = new ArrayList<WebElement>();
		try {
//			linkForCustomerSupport.forEach(item -> {
//				links.add(item);
//			});
//			System.out.println(links);
			linkForEchoSupport.click();
			isSucceed = true;
		} catch (Exception e) {
			e.printStackTrace();
			isSucceed = false;
		}
		return isSucceed;
	}
	
	
	
	
	
}
