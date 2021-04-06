package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {

	WebDriver driver = null;

	@FindBy(id = "ap_customer_name")
	WebElement customerNameInput;

	@FindBy(id = "ap_email")
	WebElement customerEmailInput;
	
	@FindBy(xpath = "//div[@id='legalTextRow']//child::a[contains(text(), 'Conditions of Use') or contains(text(), 'Aviso de Privacidad')]")
	WebElement conditionUseLink;

	public CreateAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean setAccountDetails(String name, String email) {
		boolean isSucceed;
		try {
			customerNameInput.sendKeys(name);
			customerEmailInput.sendKeys(email);
			isSucceed = true;
		} catch (Exception e) {
			e.printStackTrace();
			isSucceed = false;
		}
		return isSucceed;
	}
	
	public boolean clickConditionUse() {
		boolean isSucceed;
		try {
			conditionUseLink.click();
			isSucceed = true;
		} catch (Exception e) {
			e.printStackTrace();
			isSucceed = false;
		}
		return isSucceed;
	}
}
