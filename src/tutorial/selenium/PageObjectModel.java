package tutorial.selenium;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import page.classes.SearchPage;

/***
 * Section 25 Lecture 140
 * Page Object Model
 * 
 * @author Juan-Luis.Vivas
 *
 */
class PageObjectModel {
	private WebDriver driver;
	private String baseUrl;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\gecko32\\geckodriver.exe");
		driver = new FirefoxDriver();
		baseUrl = "https://www.expedia.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	void test() {
		driver.get(baseUrl);
		SearchPage.navigateToFlightTab(driver);
		SearchPage.fillOriginTextBox(driver,"New York");
		SearchPage.fillDestinationTextBox(driver, "Chicago");
		SearchPage.fillDepartureDate(driver, "02/02/2019");
		SearchPage.fillReturnDate(driver, "03/03/2019");
		SearchPage.clickOnSearchButton(driver);
	}

	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
