package mail_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends AbstractPage{

	WebDriver driver;
	private static final By EMAIL_INPUT_LOCATOR = By.id("mailbox:login");
	private static final By PASSWORD_INPUT_LOCATOR = By.id("mailbox:password");
	private static final By GO_BUTTON_LOCATOR = By.xpath("//input[@type='submit']");
		
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void open() {
		driver.get("https://mail.ru");
	}
	
	public void fillLoginEmail (String query) {
		//waitForElementPresent(EMAIL_INPUT_LOCATOR);
		driver.findElement(EMAIL_INPUT_LOCATOR).clear();
		driver.findElement(EMAIL_INPUT_LOCATOR).sendKeys(query);
		
	}
	
	public void fillLoginPassword (String query) {
		//waitForElementPresent(EMAIL_INPUT_LOCATOR);
		driver.findElement(PASSWORD_INPUT_LOCATOR).clear();
		driver.findElement(PASSWORD_INPUT_LOCATOR).sendKeys(query);
		
	}

	public HomePage goToHome () {
		driver.findElement(GO_BUTTON_LOCATOR).click();
		return new HomePage(driver);
	}

}