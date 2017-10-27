package mail_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewMailPage {

	WebDriver driver;
	private static final By ADDRESS_LOCATOR = By.xpath("//textarea[@data-original-name='To']");
	private static final By SUBJECT_LOCATOR = By.xpath("//input[@name='Subject']");
	private static final By MESSAGE_LOCATOR = By.xpath("//body[@id='tinymce']");
	private static final By SAVE_LOCATOR = By.xpath("//div[@data-name='saveDraft']");
	private static final By DRAFTS_LOCATOR = By.xpath("//a[@data-mnemo='drafts']");
	
	
	
	public NewMailPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void fillAdress(String query) {
		driver.findElement(ADDRESS_LOCATOR).sendKeys(query);
	}
	
	public void fillSubject(String query) {
		driver.findElement(SUBJECT_LOCATOR).sendKeys(query);
	}
	
	public void fillBody(String query) {
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='{#aria.rich_text_area}']"))); 
		driver.findElement(MESSAGE_LOCATOR).click();
		driver.findElement(MESSAGE_LOCATOR).clear();
		driver.findElement(MESSAGE_LOCATOR).sendKeys(query);
		driver.switchTo().parentFrame();
	}
	
	public void saveDraft() {
				driver.findElement(SAVE_LOCATOR).click();
	}
	
	public DraftsPage goToDrafts() {
		driver.findElement(DRAFTS_LOCATOR).click();
		return new DraftsPage(driver);
	}
}