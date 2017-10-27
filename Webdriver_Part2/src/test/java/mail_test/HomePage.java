package mail_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {
	WebDriver driver;
	private static final boolean LOGGED_LOCATOR = By.id("PH_user-email") != null;
	private static final By NEWMAIL_BUTTON_LOCATOR = By.cssSelector(".b-toolbar__item");
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void successLogin () {
		Assert.assertTrue( (LOGGED_LOCATOR), "Looks you are NOT logged in correctly!");
	}
	
	public NewMailPage goToNewMail () {
		driver.findElement(NEWMAIL_BUTTON_LOCATOR).click();
		return new NewMailPage(driver);
	}
}
