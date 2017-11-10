package mail_test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit; 

public class MailTestRun {
	
	private WebDriver driver;
	//private WebDriverWait wait;
	
	private static final String LOGIN = "beltests";
	private static final String PASSWORD = "bellator123";
	private static final String EMAIL = "m.nasevich@gmail.com";
	private static final String SUBJECT = "Selenium WebDriver";
	private static final String MAILTEXT = "Test page objects";
	

  @BeforeClass (description = "Start Browser")
  private void initBrowser () {
	  System.setProperty("webdriver.chrome.driver", "d:\\install\\WebDriver\\chromedriver.exe");
	  driver = new ChromeDriver();
	 // wait = new WebDriverWait(driver, 10);
	  driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	 }
  
	
  /* 
   @AfterClass
   public void kill() {
	   driver.close();
   }
  */

	
  @Test
  public void testMail() {
	  HomePage homePage = new LoginPage(driver).open().closePopUp().fillLoginEmail(LOGIN).fillLoginPassword(PASSWORD).goToHome();
	  homePage.successLogin();
	  NewMailPage newMailPage = homePage.goToNewMail();
	  newMailPage.fillAddress(EMAIL).fillSubject(SUBJECT).fillBody(MAILTEXT).saveDraft();
	  DraftsPage draftsPage = newMailPage.goToDrafts();
	  draftsPage.verified();
	  MailPage mailPage = draftsPage.goToMail();
	  mailPage.addressEquals(EMAIL+",").subjectEquals(SUBJECT).bodyEquals(MAILTEXT).sendMessage();
	  draftsPage.checkNoDraft();
	  SentPage sentPage = draftsPage.goToSent();
	  sentPage/*.checkForSent(EMAIL)*/.logOut();
	  
	 
  }
  
}
