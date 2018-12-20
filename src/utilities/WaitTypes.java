package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/***
 * Section 18 Lecture 110
 * Utilities wait type
 * @author juanl
 *
 */
public class WaitTypes {
	WebDriver driver;
	
	public WaitTypes (WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement waitForElement(By locator, int timeout) {
		WebElement element = null;
		
		try {
			System.out.println("Waiting for max:: "+ timeout + " seconds for element to be available");
			
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			
			System.out.println("Element appeared on the webpage");
			
		} catch (Exception e) {
			System.out.println("Element not appeared on the webpage");
		}
		return element;
	}
}
