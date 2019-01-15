package page.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/***
 * Section 25 Lecture 142
 * Page Factory
 * 
 * @author juanl
 *
 */
public class SearchPageFactory2 {
	WebDriver driver;
	
	@FindBy(id="primary-header-flight")
	WebElement flightTab;
	
	@FindBy(id="flight-origin-hp-flight")
	WebElement flightOrigin;
	
	@FindBy(id="flight-destination-hp-flight")
	WebElement flightDestination;
	
	@FindBy(id="flight-departing-hp-flight")
	WebElement dateDeparting;
	
	@FindBy(id="flight-returning-hp-flight")
	WebElement dateReturn;
	
	@FindBy(xpath="//form[@id='gcw-flights-form-hp-flight']//button[@type='submit']")
	WebElement buttonSearch;
	
	public void SearchPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickFlightsTab() {
		flightTab.click();
	}
	
	public void setOriginCity(String origin) {
		flightOrigin.sendKeys(origin);
	}
	
	public void setDestinationCity(String destination) {
		flightDestination.sendKeys(destination);
	}
	
	public void setDateDeparting(String date) {
		dateDeparting.sendKeys(date);
	}
	
	public void setReturnDate(String date) {
		dateReturn.sendKeys(date);
	}
	
	public void clickSearchFlight() {
		buttonSearch.click();
	}
}
