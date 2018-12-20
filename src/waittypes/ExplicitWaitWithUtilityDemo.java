package waittypes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.WaitTypes;

/***
 * Section 18 Lecture 110
 * Explicit Waits with utilities wait type
 * @author juanl
 *
 */
class ExplicitWaitWithUtilityDemo {
	private WebDriver driver;
	private String baseUrl;
	private WaitTypes wt;
	
	@BeforeEach
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\gecko32\\geckodriver.exe");
		driver = new FirefoxDriver();
		baseUrl = "https://learn.letskodeit.com/p/practice";
		wt = new WaitTypes(driver);
		
		driver.manage().window().maximize();
	}

	@Test
	public void test() {
		driver.get(baseUrl);
		WebElement loginLink = driver.findElement(By.linkText("Login"));
		loginLink.click();
		
		WebElement emailField = wt.waitForElement(By.id("user_email"), 3);	
		emailField.sendKeys("test");
		//driver.findElement(By.id("user_email")).sendKeys("test");
		
		wt.clickWhenReady(By.name("commit"), 3);
	}
	
	@AfterEach
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		//driver.quit();
	}

}
