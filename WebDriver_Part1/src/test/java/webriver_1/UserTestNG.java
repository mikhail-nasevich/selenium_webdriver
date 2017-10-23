package webriver_1;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserTestNG {
	
  private WebDriver driver;

  @BeforeClass
  public void beforeClass() {
      driver = new FirefoxDriver();
  }

  @AfterClass
  public void afterClass() {
      driver.quit();
  }

  @Test
  public void verifyUser() {

      driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

      driver.get("https://github.com/n-mikhail/selenium_webdriver");

      String text = "n-mikhail";
      WebElement search_user = driver.findElement(By.className("user-mention"));

      String user = search_user.getText();

      Assert.assertEquals(text, user);
  }
}