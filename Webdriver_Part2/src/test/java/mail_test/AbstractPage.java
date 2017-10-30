package mail_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AbstractPage {
	private  WebDriver driver;
	public static final int WAIT_FOR_ELEMENT_SEC = 10;
	
	//public AbstractPage(WebDriver driver) {
	//	this.driver = driver;
	//}
	
	public boolean isElementPresent(By locator) {
		return !driver.findElements(locator).isEmpty();
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
