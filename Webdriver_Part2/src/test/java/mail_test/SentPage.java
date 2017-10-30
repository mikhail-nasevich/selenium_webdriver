package mail_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SentPage {

	WebDriver driver;
	private static final boolean SENT_PAGE_LOCATOR = By.cssSelector("div.b-datalist__item__panel") != null;
	private static final By LOGOUT_LOCATOR = By.id("PH_logoutLink");	
	
	
	
	public SentPage(WebDriver driver) {
		this.driver=driver;
	}
	

	public void checkForSent() {
		Assert.assertTrue((SENT_PAGE_LOCATOR), "Looks like NO any sent message.");
		}
	
		
	public void logOut () {
		driver.findElement(LOGOUT_LOCATOR).click();
	}
	
}

