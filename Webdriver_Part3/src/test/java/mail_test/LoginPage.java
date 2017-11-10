package mail_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

	@FindBy(id = "mailbox:login")
	WebElement EMAIL_INPUT;
	
	@FindBy(id = "mailbox:password")
	WebElement PASSWORD_INPUT;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement GO_BUTTON;
	
	@FindBy(css = "a.tutorial__close")
	WebElement CLOSE_POPUP;
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public LoginPage open() {
		getDriver().get("https://mail.ru");
		return this;
		}
	
	public LoginPage closePopUp() {
		CLOSE_POPUP.click();
		return this;
		
	}
	
	public LoginPage fillLoginEmail (String query) {
		//waitForElementPresent(EMAIL_INPUT_LOCATOR);
		EMAIL_INPUT.clear();
		EMAIL_INPUT.sendKeys(query);
		return this;
		
	}
	
	public LoginPage fillLoginPassword (String query) {
		//waitForElementPresent(EMAIL_INPUT_LOCATOR);
		PASSWORD_INPUT.clear();
		PASSWORD_INPUT.sendKeys(query);
		return this;
	}

	public HomePage goToHome () {
		GO_BUTTON.click();
		return new HomePage(getDriver());
	}

}