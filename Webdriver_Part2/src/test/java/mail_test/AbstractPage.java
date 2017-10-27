package mail_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AbstractPage {

	public static final int WAIT_FOR_ELEMENT_SEC = 10;
	private WebDriver driver;
	
	public boolean isElementPresent(By locator) {
		return driver.findElement(locator).isDisplayed();
	}
	
	public void waitForElementPresent(By locator) {
		new WebDriverWait(driver, WAIT_FOR_ELEMENT_SEC).until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
	
	public void waitForElementVisible(By locator) {
		new WebDriverWait(driver, WAIT_FOR_ELEMENT_SEC).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	public void waitForElementEnabled(By locator) {
		new WebDriverWait(driver, WAIT_FOR_ELEMENT_SEC).until(ExpectedConditions.elementToBeClickable(locator));
	}
}
