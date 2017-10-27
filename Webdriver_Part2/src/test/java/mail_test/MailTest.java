package mail_test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit; 

public class MailTest {
	
	private WebDriver driver;
	

  @BeforeClass (description = "Start Browser")
  public void initBrowser () {
	  System.setProperty("webdriver.chrome.driver", "d:\\install\\WebDriver\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	 }
  
	@BeforeClass (dependsOnMethods = "initBrowser", description = "Add implicitly")
	 public void addTimeout () {
		// setting standard timeout
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	 }

    @AfterClass
 	 public void kill() {
    	driver.close();
	 }
  

	
  @Test
  public void testMail() {
	  LoginPage loginPage = new LoginPage(driver);
	  loginPage.open();
	  loginPage.fillLoginEmail("beltests");
	  loginPage.fillLoginPassword("bellator123");
	  HomePage homePage = loginPage.goToHome();
	  homePage.successLogin();
	  NewMailPage newMailPage =homePage.goToNewMail();
	  newMailPage.fillAdress("m.nasevich@gmail.com");
	  newMailPage.fillSubject("Selenium WebDriver");
	  newMailPage.fillBody("test page objects");
	  newMailPage.saveDraft();
	  DraftsPage newDraftsPage =newMailPage.goToDrafts();
	  newDraftsPage.checkForDraft();
	  
	  
	  
	  
	  
	  
	  
  }
  
}
