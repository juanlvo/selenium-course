package interviewquestions;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/***
 * Section 24 Lecture 135
 * Interviews questions example 1
 * 
 * @author Juan-Luis.Vivas
 *
 */
class NoSuchElementDemo {
	private WebDriver driver;
	private String baseUrl;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "https://letskodeit.teachable.com/";
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	void test() {
		driver.get(baseUrl);
		
		// 1. Timing issues
		driver.findElement(By.xpath("//a[@class='navbar-link fedora-navbar-link']")).click();
		//WebElement emailField = driver.findElement(By.id("user_email"));
		//emailField.sendKeys("testing");
		WebDriverWait wait = new WebDriverWait(driver, 3);
		WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_email")));
		emailField.sendKeys("testing");
		
		// 2. Incorrect locator or type of locator
		driver.findElement(By.xpath("/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/a[1]/img[1]")).click();
		
		// 3. Element is in iFrame
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.switchTo().frame("courses-iframe");
		driver.findElement(By.id("search-courses")).sendKeys("Java");
		driver.switchTo().defaultContent();
	}
	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
