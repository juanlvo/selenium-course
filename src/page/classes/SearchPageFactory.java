package page.classes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/***
 * Section 25 Lecture 141
 * Object Repository and Page Class
 * 
 * @author Juan-Luis.Vivas
 *
 */
public class SearchPageFactory {
	
	@FindBy(id="tab-flight-tab-hp")
	WebElement flightsTab;
	
	@FindBy(id="flight-type-roundtrip-label-hp-flight")
	WebElement roundTrip;
	
	@FindBy(id="flight-type-multi-dest-label-hp-flight")
	WebElement multipleDestination;
	
	public void clickFlightTab() {
		flightsTab.click();
	}
	
	public void clickRoundTrip() {
		roundTrip.click();
	}
	
	public void clickMultipleDestination() {
		multipleDestination.click();
	}
}
