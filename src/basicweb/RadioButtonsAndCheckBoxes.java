package basicweb;

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
 * Section 16 lecture 93
 * Check boxes and radio buttons
 * 
 * @author Juan-Luis.Vivas
 *
 */
class RadioButtonsAndCheckBoxes {
	
	WebDriver driver;
	String baseUrl;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\gecko32\\geckodriver.exe");
		driver = new FirefoxDriver();
		baseUrl = "https://learn.letskodeit.com/p/practice";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}

	@Test
	void test() throws InterruptedException {
		WebElement bmwRadioBtn = driver.findElement(By.id("bmwradio"));
		bmwRadioBtn.click();
		
		Thread.sleep(2000);
		WebElement benzRadioBtn = driver.findElement(By.id("benzradio"));
		benzRadioBtn.click();
		
		Thread.sleep(2000);
		WebElement bmwCheckBox = driver.findElement(By.id("bmwcheck"));
		bmwCheckBox.click();
		
		Thread.sleep(2000);
		WebElement benzCheckBox = driver.findElement(By.id("benzcheck"));
		benzCheckBox.click();
		
		System.out.println("BMW Radio is selected? "+bmwRadioBtn.isSelected());
		System.out.println("Benz Radio is selected? "+benzRadioBtn.isSelected());
		System.out.println("BMW check is selected? "+bmwCheckBox.isSelected());
		System.out.println("Benz check is selected? "+benzCheckBox.isSelected());
	}
	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}



}
