package mail_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MailPage {

	WebDriver driver;
	private static final By ADDRESS_LOCATOR = By.xpath("//textarea[@data-original-name='To']");
	private static final By SUBJECT_LOCATOR = By.xpath("//input[@name='Subject']");
	private static final By MESSAGE_LOCATOR = By.xpath("//body[@id='tinymce']");
	private static final By SEND_LOCATOR = By.xpath("//div[@data-name='send']");
	private static final By DRAFTS_LOCATOR = By.xpath("//a[@data-mnemo='drafts']");
	//private static final By DRAFTS_LOCATOR = By.xpath("//a[@data-mnemo='drafts']");
	
	
	
	public MailPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void addressEquals(String query){
        Assert.assertEquals((ADDRESS_LOCATOR), query);
	}
	
	public void subjectEquals(String query){
        Assert.assertEquals((SUBJECT_LOCATOR), query);
	}
	
	public void bodyEquals(String query){
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='{#aria.rich_text_area}']"))); 
        Assert.assertEquals((MESSAGE_LOCATOR), query);
        driver.switchTo().parentFrame();
	}
	
	public void sendMessage () {
		driver.findElement(SEND_LOCATOR).click();
	}
	
	public DraftsPage toDrafts() {
		driver.findElement(DRAFTS_LOCATOR).click();
		return new DraftsPage(driver);
	}
}
