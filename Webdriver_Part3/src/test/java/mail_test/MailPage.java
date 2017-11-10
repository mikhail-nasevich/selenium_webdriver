package mail_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MailPage extends AbstractPage{

	@FindBy(id= "compose_to")
	WebElement FILLED_ADDRESS;
	
	@FindBy(css= "a.js-href.b-datalist__item__link")
	WebElement  FILLED_SUBJECT;
	
	@FindBy(xpath= "//div[@data-blockid='compose_to']")
	WebElement  ADRESS_FIELD;
	
	@FindBy(xpath= "//body[@id='tinymce']/div/div/div/div")
	WebElement  FILLED_MESSAGE;
	
	@FindBy(xpath= "//input[@name='Subject']")
	WebElement  SUBJECT;
	
	@FindBy(xpath= "//body[@id='tinymce']")
	WebElement MESSAGE;
	
	@FindBy(xpath= "//div[@data-name='send']")
	WebElement SEND;
	
	@FindBy(xpath= "//a[@data-mnemo='drafts']")
	WebElement DRAFTS;
	
	
	
	public MailPage(WebDriver driver) {
		super (driver);
	}
	
	public String readAddress(){
		//waitForElementIsVisible(FILLED_ADDRESS);
		FILLED_ADDRESS.getAttribute("value");
        return FILLED_ADDRESS.getAttribute("value");
	}
	
	public String readSubject(){
		//waitForElementIsVisible(FILLED_SUBJECT);
		FILLED_SUBJECT.getAttribute("data-subject");
        return FILLED_SUBJECT.getAttribute("data-subject");
	}
	
	public String readMessage(){
		//waitForElementIsVisible(FILLED_MESSAGE);
		getDriver().switchTo().frame(getDriver().findElement(By.xpath("//iframe[@title='{#aria.rich_text_area}']"))); 
        FILLED_MESSAGE.getText();
        //getDriver().switchTo().parentFrame();
        return FILLED_MESSAGE.getText();
      	}
	
	public MailPage addressEquals(String query){
		waitForElementIsVisible(ADRESS_FIELD);
        Assert.assertEquals(readAddress(), query);
        return this;
	}
	
	public MailPage subjectEquals(String query){
        Assert.assertEquals(readSubject(), query);
        return this;
	}
	
	public MailPage bodyEquals(String query){
		Assert.assertEquals(readMessage(), query);
		getDriver().switchTo().parentFrame();
        return this;
	}
	
	public MailPage sendMessage () {
		SEND.click();
		return this;
	}
	
	public DraftsPage toDrafts() {
		DRAFTS.click();
		return new DraftsPage(getDriver());
	}
}
