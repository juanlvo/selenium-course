package tutorial.selenium;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import page.classes.SearchPageFactory2;

/***
 * Section 25 Lecture 142
 * Page Factory
 * 
 * @author juanl
 *
 */
class FrameTestCase {
	private WebDriver driver;
	private String baseUrl;
	SearchPageFactory2 searchPage;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\gecko32\\geckodriver.exe");
		driver = new FirefoxDriver();
		baseUrl = "https://www.expedia.com/";
		searchPage = new SearchPageFactory2();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@Test
	void test() {
		searchPage.clickFlightsTab();
		searchPage.setOriginCity("New York");
		searchPage.setDestinationCity("Chicago");
		searchPage.setDateDeparting("02/02/2019");
		searchPage.setReturnDate("03/03/2019");
		searchPage.clickSearchFlight();
	}
	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(3000);
		//driver.quit();
	}

}
