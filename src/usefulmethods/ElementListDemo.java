package usefulmethods;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import usefulmethods.GenericMethods;

/***
 * Section 17 Lecture 104
 * Generic Methods to find Elements List
 * 
 * @author Juan-Luis.Vivas
 *
 */
class ElementListDemo {
	
	private WebDriver driver;
	private String baseUrl;
	private GenericMethods gm;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\gecko32\\geckodriver.exe");
		driver = new FirefoxDriver();
		baseUrl = "https://learn.letskodeit.com/p/practice";
		gm = new GenericMethods(driver);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	void test() {
		driver.get(baseUrl);
		
		List <WebElement> elementList = gm.getElementList("//input[@type='text']", "xpath");
		int size = elementList.size();
		System.out.println("Size of the element "+size);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
