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
	  loginPage.fillLoginEmail("beltests");
	  loginPage.fillLoginPassword("bellator123");
	  HomePage homePage = loginPage.goToHome();
	  homePage.successLogin();
	  NewMailPage newMailPage = homePage.goToNewMail();
	  newMailPage.fillAddress("m.nasevich@gmail.com");
	  newMailPage.fillSubject("Selenium WebDriver");
	  newMailPage.fillBody("test page objects");
	  newMailPage.saveDraft();
	  DraftsPage draftsPage =newMailPage.goToDrafts();
	  draftsPage.checkForDraft();
	  MailPage mailPage = draftsPage.goToMail();
	  //verify address. add "," after address 
	  String actualAddress = mailPage.readAddress();
	  Assert.assertEquals(actualAddress, "m.nasevich@gmail.com,");
	  // verify subject of email
	  String actualSubject = mailPage.readSubject();
	  Assert.assertEquals(actualSubject, "Selenium WebDriver");
	  // verify text of mail
	  String actualMessage = mailPage.readMessage();
	  Assert.assertEquals(actualMessage, "test page objects");
	  mailPage.sendMessage();
	  draftsPage.checkNoDraft();
	  SentPage sentPage = draftsPage.goToSent();
	  sentPage.checkForSent();
	  sentPage.logOut();
	  
		  
  }
  
}
