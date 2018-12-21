package tutorialselenium;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/***
 * Section 19 Lecture 114
 * Calender Selection Example
 * 
 * @author juanl
 *
 */
class CalenderSelection {
	private WebDriver driver;
	private String baseUrl;

	@BeforeEach
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\gecko32\\geckodriver.exe");
		driver = new FirefoxDriver();
		baseUrl = "https://www.expedia.com/";
		
		driver.manage().window().maximize();
	}

	@Test
	public void test1() {
		driver.get(baseUrl);
		//click flight tab
		driver.findElement(By.id("tab-flight-tab-hp")).click();
		//find departing flight
		WebElement departingField = driver.findElement(By.id("flight-departing-hp-flight"));
		//click in the departing field
		departingField.click();
		//Find the date to be selected
		WebElement dateToSelect = driver.findElement(By.xpath("/html/body/meso-native-marquee/section/div/div/div[1]/section/div/div[2]/div[2]/section[1]/form/fieldset[2]/div/div[2]/div/div/div/div[2]/table/tbody/tr[6]/td[2]/button"));
		//click the date
		dateToSelect.click();
	}
	
	
	
	@AfterEach
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
