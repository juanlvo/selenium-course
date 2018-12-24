package tutorialselenium;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

/***
 * Section 19 Lecture 117
 * Example of Screenshots
 * 
 * @author juanl
 *
 */
class Screenshots {

	private WebDriver driver;
	private String baseUrl;
	
	@BeforeEach
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\gecko32\\geckodriver.exe");
		driver = new FirefoxDriver();
		baseUrl = "https://www.expedia.com/";
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test() {
		String partialText = "New York";
		driver.get(baseUrl);
		
		driver.findElement(By.id("tab-flight-tab-hp")).click();
		
		WebElement flightOrigin = driver.findElement(By.id("flight-origin-hp-flight"));
		WebElement flightDestination = driver.findElement(By.id("flight-destination-hp-flight"));
		WebElement dateDeparture = driver.findElement(By.id("flight-departing-hp-flight"));
		WebElement dateReturn = driver.findElement(By.id("flight-returning-hp-flight"));
		
		flightOrigin.sendKeys(partialText);
		flightDestination.sendKeys(partialText);
		dateDeparture.sendKeys("01/01/2019");
		dateReturn.clear();
		dateReturn.sendKeys("01/02/2019");

		driver.findElement(By.xpath("//form[@id='gcw-flights-form-hp-flight']//button[@type='submit']")).click();
		
	}
	
	public static String getRandomString(int length) {
		StringBuilder sb = new StringBuilder();
		String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		for (int i=0; i < length; i++) {
			int index = (int) Math.random() * characters.length();
			sb.append(characters.charAt(index));
		}
		return sb.toString();
	}
	
	@AfterEach
	public void tearDown() throws Exception {
		String fileName = getRandomString(10) + ".png";
		String directory = "D:\\eclipse-workspace\\selenium-course\\img\\";
		
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileHandler.copy(sourceFile, new File(directory + fileName));
		
		Thread.sleep(3000);
		driver.quit();
	}

}
