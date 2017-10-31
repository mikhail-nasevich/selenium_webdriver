package mail_test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit; 

public class MailTestRun {
	
	private WebDriver driver;
	private static final String LOGIN = "beltests";
	private static final String PASSWORD = "bellator123";
	private static final String EMAIL = "m.nasevich@gmail.com";
	private static final String SUBJECT = "Selenium WebDriver";
	private static final String MAILTEXT = "Test page objects";
	

  @BeforeClass (description = "Start Browser")
  private void initBrowser () {
	  System.setProperty("webdriver.chrome.driver", "d:\\install\\WebDriver\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	 }
  
	
    @AfterClass
 	public void kill() {
    	driver.close();
	}
  

	
  @Test
  public void testMail() {
	  LoginPage loginPage = new LoginPage(driver);
	  loginPage.open();
	  loginPage.closePopUp();
	  loginPage.fillLoginEmail(LOGIN);
	  loginPage.fillLoginPassword(PASSWORD);
	  HomePage homePage = loginPage.goToHome();
	  homePage.successLogin();
	  NewMailPage newMailPage = homePage.goToNewMail();
	  newMailPage.fillAddress(EMAIL);
	  newMailPage.fillSubject(SUBJECT);
	  newMailPage.fillBody(MAILTEXT);
	  newMailPage.saveDraft();
	  DraftsPage draftsPage =newMailPage.goToDrafts();
	  draftsPage.checkForDraft();
	  MailPage mailPage = draftsPage.goToMail();
	  //verify address. add "," after address 
	  String actualAddress = mailPage.readAddress();
	  Assert.assertEquals(actualAddress, EMAIL+",");
	  // verify subject of email
	  String actualSubject = mailPage.readSubject();
	  Assert.assertEquals(actualSubject, SUBJECT);
	  // verify text of mail
	  String actualMessage = mailPage.readMessage();
	  Assert.assertEquals(actualMessage, MAILTEXT);
	  mailPage.sendMessage();
	  draftsPage.checkNoDraft();
	  SentPage sentPage = draftsPage.goToSent();
	  sentPage.checkForSent();
	  sentPage.logOut();
	  
		  
  }
  
}
