package workingwithelements;

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
import org.openqa.selenium.support.ui.Select;

/***
 * Section: 16 Lecture 96: Dropdown select
 * 
 * @author Juan-Luis.Vivas
 *
 */
class DropdownSelect {

	WebDriver driver;
	String baseUrl;
	
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\gecko32\\geckodriver.exe");
		driver = new FirefoxDriver();
		baseUrl = "https://learn.letskodeit.com/p/practice";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	void test() throws InterruptedException {
		driver.get(baseUrl);
		WebElement element = driver.findElement(By.id("carselect"));
		Select sel = new Select(element);
		
		Thread.sleep(2000);
		System.out.println("Select Benz by value");
		sel.selectByValue("benz");
		
		Thread.sleep(2000);
		System.out.println("Select Honda by index");
		sel.selectByIndex(2);
		
		Thread.sleep(2000);
		System.out.println("Select BMW by visible text");
		sel.selectByVisibleText("BMW");
		
		Thread.sleep(2000);
		System.out.println("Print the list of all options");
		List<WebElement> options = sel.getOptions();
		
		int size = options.size();
		
		for (int i=0; i < size; i++) {
			String optionName = options.get(i).getText();
			System.out.println(optionName);
		}
	}
	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}



}
