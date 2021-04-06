package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import setup.KeyPad;

public class HelpCustomerServicePage extends KeyPad{
	
	WebDriver driver;
	
	@FindBy(id="helpsearch")
	WebElement helpSearchInput;
	
	@FindBy(className="a-link-normal")
	List<WebElement> linkForCustomerSupport;
	
	@FindBy(xpath="//a[contains(text(), 'Echo Support')]")
	WebElement linkForEchoSupport;
	
	@FindBy(xpath="//div[@class='a-column a-span4']//child::h4")
	List<WebElement> resultsText;
	
	public HelpCustomerServicePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public boolean searchInInput(String searchCriteria) {
		boolean isSucceed;
		try {
			//WebDriverWait wait = new WebDriverWait(driver, 6);
			//WebElement inputSearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("helpsearch")));
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
	
	
	public boolean validateResults(String item1, String item2, String item3, String item4, String item5) {
		boolean isSucceed =  false;
		List<String> theResults = new ArrayList<String>();
		List<String> myList = new ArrayList<String> ();
		myList.add(item1);
		myList.add(item2);
		myList.add(item3);
		myList.add(item4);
		myList.add(item5);
		try {
			resultsText.forEach(result -> {
				theResults.add(result.getText());
				System.out.println(result.getText());
			});
			if(theResults.equals(myList)) {				
				isSucceed = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			isSucceed = false;
		}
		return isSucceed;
	}
	
	
	
	
}
