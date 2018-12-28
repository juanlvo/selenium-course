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
 * Section 20 Lecture 121
 * Click with JavaScript example
 * 
 * @author juanl
 *
 */
class JavaScriptClick {
	private WebDriver driver;
	private JavascriptExecutor js;
	
	@BeforeEach
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\gecko32\\geckodriver.exe");
		driver = new FirefoxDriver();
		js = (JavascriptExecutor) driver;
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

/*	@Test
	public void testJSClick1() throws InterruptedException {
		//Navigation
		js.executeScript("window.location = 'https://learn.letskodeit.com/p/practice';");
		Thread.sleep(2000);
		
		WebElement checkbox = driver.findElement(By.id("bmwcheck"));
		js.executeScript("arguments[0].click();", checkbox);
	}*/
	
	@Test
	public void testJSClick2() throws InterruptedException {
		//Navigation
		js.executeScript("window.location = 'https://www.retailmenot.com/';");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@class='icon icon-close']")).click();
		WebElement linkLogin = driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div/div/div/div[2]/a"));
		js.executeScript("arguments[0].click();", linkLogin);
		
		Thread.sleep(3000);
		
		WebElement checkBox = driver.findElement(By.id("subscribe"));
		
		System.out.println("Displayed: "+checkBox.isDisplayed());
		System.out.println("Selected: "+checkBox.isSelected());
		
		js.executeScript("arguments[0].click();", checkBox);
	}
	
	@AfterEach
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
