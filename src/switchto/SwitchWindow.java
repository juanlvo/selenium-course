package switchto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/***
 * Section 21 Lecture 123
 * Switch Window
 * 
 * @author juanl
 *
 */
class SwitchWindow {
	private WebDriver driver;
	private String baseUrl;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\gecko32\\geckodriver.exe");
		driver = new FirefoxDriver();
		baseUrl = "https://learn.letskodeit.com/p/practice";
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}

	@Test
	void test() {
/*		WebElement openWindow = driver.findElement(By.id("openwindow"));
		openWindow.click();
		
		WebElement searchBox = driver.findElement(By.id("search-courses"));
		searchBox.sendKeys("python");*/
		
		//Get the handle
		String parentHandle = driver.getWindowHandle();
		System.out.println("Parent Handle: "+parentHandle);
		
		//Find the open window button
		WebElement openWindow = driver.findElement(By.id("openwindow"));
		openWindow.click();
		
		//Get all handles
		Set<String> handles = driver.getWindowHandles();
		
		//Switching between handles
		for(String handle: handles) {
			System.out.println(handle);
		}
		
		//Switch back to the parent window
		
	}
	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
