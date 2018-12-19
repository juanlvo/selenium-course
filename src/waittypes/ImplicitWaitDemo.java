package waittypes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import usefulmethods.GenericMethods;

class ImplicitWaitDemo {
	private WebDriver driver;
	private String baseUrl;

	@BeforeEach
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\gecko32\\geckodriver.exe");
		driver = new FirefoxDriver();
		baseUrl = "https://learn.letskodeit.com/p/practice";
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test
	public void test() {
		driver.get(baseUrl);
		driver.findElement(By.linkText("Login")).click();
		
		driver.findElement(By.id("user_email")).sendKeys("test");
	}
	
	@AfterEach
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
