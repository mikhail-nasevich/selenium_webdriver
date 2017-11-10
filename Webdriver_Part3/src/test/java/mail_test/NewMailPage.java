package mail_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class NewMailPage extends AbstractPage{

			
	@FindBy(xpath = "//textarea[@data-original-name='To']")
	WebElement ADDRESS;
	
	@FindBy(xpath = "//input[@name='Subject']")
	WebElement SUBJECT;
	
	@FindBy(xpath = "//body[@id='tinymce']")
	WebElement MESSAGE;
	
	@FindBy(xpath = "//div[@data-name='saveDraft']")
	WebElement saveDraft;
	
	@FindBy(xpath = "//a[@data-mnemo='drafts']")
	WebElement	DRAFTS;
	
	public NewMailPage(WebDriver driver) {
		super(driver);
	}
	
	public NewMailPage fillAddress(String query) {
		ADDRESS.sendKeys(query);
		return this;
	}
	
	public NewMailPage fillSubject(String query) {
		SUBJECT.sendKeys(query);
		return this;
	}
	
	public NewMailPage fillBody(String query) {
		getDriver().switchTo().frame(getDriver().findElement(By.xpath("//iframe[@title='{#aria.rich_text_area}']"))); 
		MESSAGE.click();
		MESSAGE.clear();
		MESSAGE.sendKeys(query);
		driver.switchTo().parentFrame();
		return this;
	}
	
	public NewMailPage saveDraft() {
		saveDraft.click();
		return this;
	}
	
	public DraftsPage goToDrafts() {
		//waitForElementPresent(SAVED_LOCATOR);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DRAFTS.click();
		return new DraftsPage(getDriver());
	}
	
		
}



