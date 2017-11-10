package mail_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class HomePage extends AbstractPage{
		
	@FindBy(id = "PH_user-email")
	WebElement LOGGED;
	
	@FindBy(css = ".b-toolbar__item")
	WebElement NEWMAIL_BUTTON;
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public boolean checkLogin() {
		waitForElementIsVisible(LOGGED);
		return LOGGED.isDisplayed();
	}
	
	public HomePage successLogin() {
		Assert.assertTrue(checkLogin(), "Looks you are NOT logged in correctly!");
	  	System.out.println("You are logged");
	  	return this;
	  	
	}
	
	
	public NewMailPage goToNewMail () {
		NEWMAIL_BUTTON.click();
		return new NewMailPage(getDriver());
	}
}
