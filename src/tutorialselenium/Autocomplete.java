package tutorialselenium;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/***
 * Section 19 Lecture 116
 * Autocomplete example
 * @author juanl
 *
 */
class Autocomplete {
	private WebDriver driver;
	private String baseUrl;

	@BeforeEach
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\gecko32\\geckodriver.exe");
		driver = new FirefoxDriver();
		baseUrl = "https://www.southwest.com/";
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testAutocomplete() throws InterruptedException {
		driver.get(baseUrl);
		String searchingText = "New York/Newark, NJ - EWR";
		String partialText = "New York";
		
		WebElement text = driver.findElement(By.id("air-city-departure"));
		text.sendKeys(partialText);
		
		WebElement element = driver.findElement(By.id("air-city-departure-menu"));
		List<WebElement> results = element.findElements(By.tagName("li"));
		
		int size = results.size();
		
		Thread.sleep(3000);
		
		for (int i=0; i < size; i++) {
			System.out.println(results.get(i).getText());
		}
		
		for (WebElement result : results) {
			if (result.getText().equals(searchingText)) {
				result.click();
				System.out.println("click");
			}
		}
		
	}
	
	@AfterEach
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
