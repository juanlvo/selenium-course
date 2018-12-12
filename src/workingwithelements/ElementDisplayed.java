package workingwithelements;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/***
 * Section 16 lecture 100
 * Elements displayed
 * 
 * @author Juan-Luis.Vivas
 *
 */
class ElementDisplayed {

	WebDriver driver;
	String baseUrl1;
	String baseUrl2;
	
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\gecko32\\geckodriver.exe");
		driver = new FirefoxDriver();
		baseUrl1 = "https://learn.letskodeit.com/p/practice";
		baseUrl2 = "https://www.expedia.com/";
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	void testLetsKodeIt() throws InterruptedException {
		driver.get(baseUrl1);
		
		WebElement textBox = driver.findElement(By.id("displayed-text"));
		System.out.println("Text box displayed: "+textBox.isDisplayed());
		
		Thread.sleep(3000);
		
		WebElement hideButton = driver.findElement(By.id("hide-textbox"));
		hideButton.click();
		System.out.println("Clicked on hide button");
		System.out.println("Text box displayed: "+textBox.isDisplayed());
		
		Thread.sleep(3000);
		
		//show button
		WebElement showButton = driver.findElement(By.id("show-textbox"));
		showButton.click();
		System.out.println("Clicked on show button");
		System.out.println("Text box displayed: "+textBox.isDisplayed());
		
		Thread.sleep(3000);
		
	}
	
	@Test
	void testExpedia() throws InterruptedException {
		driver.get(baseUrl2);
		WebElement travelersButton = driver.findElement(By.xpath("/html/body/meso-native-marquee/section/div/div/div[1]/section/div/div[2]/div[2]/section[3]/form/section/div[4]/div[8]/div/div/ul/li/button"));
		travelersButton.click();
		WebElement childrenButton = driver.findElement(By.xpath("/html/body/meso-native-marquee/section/div/div/div[1]/section/div/div[2]/div[2]/section[3]/form/section/div[4]/div[8]/div/div/ul/li/div/div/div[1]/div[3]/div[1]/div[4]/button"));
		childrenButton.click();
		WebElement childrenDropdown = driver.findElement(By.xpath("/html/body/meso-native-marquee/section/div/div/div[1]/section/div/div[2]/div[2]/section[3]/form/section/div[4]/div[8]/div/div/ul/li/div/div/div[1]/div[3]/div[2]/label[1]/select"));
		System.out.println("The children dropdown is visible "+childrenDropdown.isDisplayed());
		
		Thread.sleep(2000);
		
		WebElement childrenButtonMinus = driver.findElement(By.xpath("/html/body/meso-native-marquee/section/div/div/div[1]/section/div/div[2]/div[2]/section[3]/form/section/div[4]/div[8]/div/div/ul/li/div/div/div[1]/div[3]/div[1]/div[2]/button"));
		childrenButtonMinus.click();
		System.out.println("The children dropdown is visible "+childrenDropdown.isDisplayed());
		
		Thread.sleep(2000);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}


}
