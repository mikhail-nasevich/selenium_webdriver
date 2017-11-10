package mail_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SentPage extends AbstractPage {

	
	@FindBy(css= "div.b-datalist__item__addr")
	WebElement SENT_PAGE;
	
	@FindBy(id= "PH_logoutLink")
	WebElement LOGOUT;	
	
	@FindBy (id="mailbox:login")
	WebElement MAIN;	
		
	public SentPage(WebDriver driver) {
		super(driver);
	}
	
	
	public String checkMail() {
		waitForElementIsVisible(SENT_PAGE);
		SENT_PAGE.getText();
		return SENT_PAGE.getText();
	}

	public SentPage checkForSent(String query) {
		Assert.assertEquals(checkMail(), query);
		System.out.println("Message is in Sent");
		return this;
		}
	
	public boolean checkForLogOut() {
		waitForElementIsVisible(MAIN);
		return MAIN.isDisplayed();
	}
		
	public SentPage logOut () {
		LOGOUT.click();
		Assert.assertTrue(checkForLogOut(), "User is still logged in");
		System.out.println("User is logged out");
		return this;
	}
	
}

