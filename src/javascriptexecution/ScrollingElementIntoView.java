package javascriptexecution;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/***
 * Section 20 Lecture 120
 * Scrolling Elements into view
 * 
 * @author juanl
 *
 */
class ScrollingElementIntoView {
	private WebDriver driver;
	private JavascriptExecutor js;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\gecko32\\geckodriver.exe");
		driver = new FirefoxDriver();
		js = (JavascriptExecutor) driver;
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	void testScrolling() throws InterruptedException {
		//Navigation
		js.executeScript("window.location = 'https://learn.letskodeit.com/p/practice';");
		Thread.sleep(2000);
		
		//Scroll Down
		js.executeScript("window.scrollBy(0, 1900);");
		Thread.sleep(2000);
		
		//Scroll Up
		js.executeScript("window.scrollBy(0, -1900);");
		Thread.sleep(2000);
		
		//Scroll Element into view
		WebElement element = driver.findElement(By.id("mousehover"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0, -190);");
	}
	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
