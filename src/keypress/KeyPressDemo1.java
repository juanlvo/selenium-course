package keypress;


import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/***
 * Section 23 Lecture 132
 * How to press keyboard keys example
 * @author Juan-Luis.Vivas
 *
 */
class KeyPressDemo1 {
	private WebDriver driver;
	private String baseUrl;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\gecko32\\geckodriver.exe");
		driver = new FirefoxDriver();
		baseUrl = "https://learn.letskodeit.com/p/practice";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	void test() throws InterruptedException {
		driver.get(baseUrl);
		driver.findElement(By.xpath("//a[contains(@href, 'sign_in')]")).click();
		driver.findElement(By.id("user_email")).sendKeys("test@email.com");
		Thread.sleep(2000);
		//driver.findElement(By.id("user_password")).sendKeys("123123");
		//Thread.sleep(2000);
		//driver.findElement(By.name("commit")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("user_email")).sendKeys(Keys.TAB);
		Thread.sleep(2000);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}



}
