package mail_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class DraftsPage extends AbstractPage{

	@FindBy(css= "div.b-datalist__item__panel")
	WebElement DRAFTS_PAGE;
	
	@FindBy(css= "span.message-sent__info")
	WebElement EMPTY_DRAFTS;
	
	@FindBy(css= "div.b-datalist__item__panel")
	WebElement LAST_DRAFT;
	
	@FindBy(xpath= "//a[@data-shortcut='g,s']")
	WebElement SENT_MAIL;
	
	
	public DraftsPage(WebDriver driver) {
		super (driver);
	}
	
	
	public boolean checkForDraft() {
		waitForElementIsVisible(DRAFTS_PAGE);
		return DRAFTS_PAGE.isDisplayed();
	}
	
	public boolean checkNoDrafts() {
		waitForElementIsVisible(EMPTY_DRAFTS);
		return EMPTY_DRAFTS.isDisplayed();
	}
	
	public DraftsPage verified() {
	Assert.assertTrue(checkForDraft(), "Message was not be saved");
	System.out.println(" - Message was saved");
	return this;
	}
	
	public MailPage goToMail () {
		LAST_DRAFT.click();
		return new MailPage(getDriver());
	}
	

	public DraftsPage checkNoDraft() {
		Assert.assertTrue(checkNoDrafts(), "Message was not be sent");
		System.out.println(" - Message was sent");
		return this;
		}
	
	public SentPage goToSent () {
		SENT_MAIL.click();
		return new SentPage(getDriver());
	}
	
}
