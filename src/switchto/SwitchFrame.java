package switchto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/***
 * Section 21 Lecture 125 / 126
 * Switch iFrame
 * 
 * @author juanl
 *
 */
class SwitchFrame {
	private WebDriver driver;
	private String baseUrl;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\gecko32\\geckodriver.exe");
		driver = new FirefoxDriver();
		baseUrl = "https://learn.letskodeit.com/p/practice";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@Test
	void test() throws InterruptedException {
		Thread.sleep(3000);
		//Switch frame by id
		//driver.switchTo().frame("courses-iframe");
		
		//Switch frame by name
		//driver.switchTo().frame("iframe-name");
		
		//Switch by number
		driver.switchTo().frame(0);
		
		WebElement searchBox = driver.findElement(By.id("search-courses"));
		searchBox.sendKeys("python");
		
		driver.switchTo().defaultContent();
		Thread.sleep(6000);
		driver.findElement(By.id("name")).sendKeys("Test Successfull");
	}
	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
