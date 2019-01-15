package page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/***
 * Section 25 Lecture 140
 * Page Object Model
 * 
 * @author Juan-Luis.Vivas
 *
 */
public class SearchPage {
	public static WebElement element = null;

	/**
	 * Returns the flight origin text box element
	 * @param driver
	 * @return
	 */
	public static WebElement originTextBox(WebDriver driver) {
		element = driver.findElement(By.id("flight-origin-hp-flight"));
		return element;
	}
	
	/**
	 * Fill the field origin text box
	 * @param driver
	 * @param origin
	 */
	public static void fillOriginTextBox(WebDriver driver, String origin) {
		element = originTextBox(driver);
		element.sendKeys(origin);
	}
	/**
	 * Returns the flight destination text box element
	 * @param driver
	 * @return 
	 */
	public static WebElement destinationTextBox(WebDriver driver) {
		element = driver.findElement(By.id("flight-destination-hp-flight"));
		return element;
	}
	
	/**
	 * fill the destination text box
	 * @param driver
	 * @param destination
	 */
	public static void fillDestinationTextBox(WebDriver driver, String destination) {
		element = destinationTextBox(driver);
		element.sendKeys(destination);
	}
	
	/**
	 * Returns the departure date text box element
	 * @param driver
	 * @return
	 */
	public static WebElement departureDateTextBox(WebDriver driver) {
		element = driver.findElement(By.id("flight-departing-hp-flight"));
		return element;
	}
	
	/**
	 * fill the departure date
	 * @param driver
	 * @param date
	 */
	public static void fillDepartureDate(WebDriver driver, String date) {
		element = departureDateTextBox(driver);
		element.sendKeys(date);
	}
	
	/**
	 * Returns the return date text box element
	 * @param driver
	 * @return
	 */
	public static WebElement returnDateTextBox(WebDriver driver) {
		element = driver.findElement(By.id("flight-returning-hp-flight"));
		return element;
	}
	
	/**
	 * fill return date
	 * @param driver
	 * @param date
	 */
	public static void fillReturnDate(WebDriver driver, String date) {
		element = returnDateTextBox(driver);
		element.sendKeys(date);
	}
	
	/**
	 * Returns the search button element
	 * @param driver
	 * @return
	 */
	public static WebElement searchButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//form[@id='gcw-flights-form-hp-flight']//button[@type='submit']"));
		return element;
	}
	
	/**
	 * Click in the search button
	 * @param driver
	 */
	public static void clickOnSearchButton(WebDriver driver) {
		element = searchButton(driver);
		element.click();
	}
	
	/**
	 * Navigate to flight tab
	 * @driver
	 */
	public static void navigateToFlightTab(WebDriver driver) {
		element = driver.findElement(By.id("tab-flight-tab-hp"));
		element.click();
	}
}
