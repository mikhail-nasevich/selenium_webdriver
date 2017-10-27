package mail_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DraftsPage {

	WebDriver driver;
	
	private static final boolean DRAFTS_PAGE_LOCATOR = By.cssSelector("div.b-datalist__item__panel") != null;
	private static final By LAST_DRAFTS_MAIL_LOCATOR = By.cssSelector("div.b-datalist__item__panel");
	//private static final By SUBJECT_LOCATOR = By.xpath("//input[@name='Subject']");
	//private static final By MESSAGE_LOCATOR = By.id("tinymce");
	//private static final By SAVE_LOCATOR = By.xpath("//div[@data-name='saveDraft']");
	//private static final By DRAFTS_LOCATOR = By.cssSelector("css=a[href='/messages/drafts/']");
	
		
	public DraftsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void checkForDraft() {
		Assert.assertTrue((DRAFTS_PAGE_LOCATOR), "Looks like NO any Drafts saved.");
		}
	
	public MailPage goToMail () {
		driver.findElement(LAST_DRAFTS_MAIL_LOCATOR).click();
		return new MailPage(driver);
	
				}

}
