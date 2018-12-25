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
import org.openqa.selenium.support.ui.WebDriverWait;

class JavaScriptExecution {
	
	private WebDriver driver;
	private String baseUrl;
	private JavascriptExecutor js;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\gecko32\\geckodriver.exe");
		driver = new FirefoxDriver();
		baseUrl = "https://learn.letskodeit.com/p/practice";
		js = (JavascriptExecutor) driver;
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	void test() throws InterruptedException {
		//driver.get(baseUrl);
		js.executeScript("window.location = 'https://learn.letskodeit.com/p/practice';");
		//WebElement textBox = driver.findElement(By.id("name"));
		Thread.sleep(3000);
		WebElement textBox = (WebElement) js.executeScript("return document.getElementById('name');");
		textBox.sendKeys("test");
	}
	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
