package mail_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class AbstractPage {
	
	public static final int WAIT_FOR_ELEMENT_SEC = 20;
	protected WebDriver driver;
	WebDriverWait wait;
	
	
	public AbstractPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		wait = new WebDriverWait(driver, 20);
	}

	public WebDriver getDriver() {
		return this.driver;
	}
	
	
	public boolean isElementPresent(By locator) {
		return driver.findElements(locator).size() > 0;
	}
			
	public void waitForElementIsVisible(WebElement query) {
		new WebDriverWait(driver, WAIT_FOR_ELEMENT_SEC).until(ExpectedConditions.visibilityOf(query));
	}
	
	
	public void waitForElementPresent(By locator) { 
		new WebDriverWait(driver, WAIT_FOR_ELEMENT_SEC).until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	public void waitForElementEnabled(By locator) {
		new WebDriverWait(driver, WAIT_FOR_ELEMENT_SEC).until(ExpectedConditions.elementToBeClickable(locator));
	}
}
