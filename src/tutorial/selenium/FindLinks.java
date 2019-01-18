package tutorial.selenium;

import static org.junit.jupiter.api.Assertions.*;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import page.classes.SearchPage;

/***
 * Section 25 Lecture 143
 * Finding all links on a website example
 * 
 * @author Juan-Luis.Vivas
 *
 */
class FindLinks {
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
	void testFindLinks() {
		driver.get(baseUrl);
		SearchPage.navigateToFlightTab(driver);
		
		List<WebElement> linkList = clickablelinks(driver);
		for (WebElement link : linkList) {
			String href = link.getAttribute("href");
			try {
				System.out.println("URL: " + href + " returned "+linkStatus(new URL(href)));
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static List<WebElement> clickablelinks(WebDriver driver) {
		List<WebElement> linksToClick = new ArrayList<WebElement>();
		List<WebElement> elements = driver.findElements(By.tagName("a"));
		elements.addAll(driver.findElements(By.tagName("img")));
		
		for (WebElement e : elements) {
			if (e.getAttribute("href") != null) {
				linksToClick.add(e);
			}
		}
		
		return linksToClick;
	}
	
	public static String linkStatus(URL url) {
		try {
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			http.connect();
			String responseMessage = http.getResponseMessage();
			http.disconnect();
			return responseMessage;
		} catch(Exception e) {
			return e.getMessage();
		}
	}
	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
