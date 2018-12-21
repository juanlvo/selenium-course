package tutorialselenium;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/***
 * Section 19 Lecture 114-115
 * Calendar Selection Example
 * 
 * @author juanl
 *
 */
class CalendarSelection {
	private WebDriver driver;
	private String baseUrl;

	@BeforeEach
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\gecko32\\geckodriver.exe");
		driver = new FirefoxDriver();
		baseUrl = "https://www.expedia.com/";
		
		driver.manage().window().maximize();
	}


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
	
	@Test
	public void test2() {
		driver.get(baseUrl);
		//click flight tab
		driver.findElement(By.id("tab-flight-tab-hp")).click();
		//find departing flight
		WebElement departingField = driver.findElement(By.id("flight-departing-hp-flight"));
		//click in the departing field
		departingField.click();
		//find the first month in the calendar
		WebElement calMonth = driver.findElement(By.xpath("//div[@class='datepicker-cal']//div[2]//table"));
		//list of valid elements
		List<WebElement> allValidDates = calMonth.findElements(By.tagName("button"));
		
		for (WebElement date : allValidDates) {
			if (date.isEnabled()) {
				//System.out.println("is enable");
				//System.out.println("text is: "+date.getText() );
				if (date.getText().contains("30")) {
					//System.out.println("click");
					date.click();
					break;	
				}
			}
		}
	}
	
	@AfterEach
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
