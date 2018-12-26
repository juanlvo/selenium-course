package javascriptexecution;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/***
 * Section 20 Lecture 119
 * How to find the size of the window
 * @author juanl
 *
 */
class WindowSize {
	
	private WebDriver driver;
	private String baseUrl;
	private JavascriptExecutor js;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\gecko32\\geckodriver.exe");
		driver = new FirefoxDriver();
		baseUrl = "https://learn.letskodeit.com/p/practice";
		js = (JavascriptExecutor) driver;
		
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	void test() {
		//Navigation
		js.executeScript("window.location = 'https://learn.letskodeit.com/p/practice';");
		
		//Size of the window
		long height = (Long) js.executeScript("return window.innerHeight;");
		long width = (Long) js.executeScript("return window.innerWidth;");
		
		System.out.println("Height is: "+height);
		System.out.println("Width is: "+width);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}



}
