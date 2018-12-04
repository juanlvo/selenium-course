package basicweb;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/***
 * Section 16 lecture 92
 * This is the practice of enable and disable, I use I different page because google change the site
 * 
 * @author Juan-Luis.Vivas
 *
 */
class ElementState {
	WebDriver driver;
	String baseUrl;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\gecko32\\geckodriver.exe");
		driver = new FirefoxDriver();
		baseUrl = "https://www.htmlgoodies.com/tutorials/forms/article.php/3479101/Triminds---Enable-and-Disable.htm";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}

	@Test
	void test() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2500)");
		WebElement e1 = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div[1]/div[2]/div[2]/table[8]/tbody/tr/td/form/input[1]"));
		System.out.println("e1 is enable? "+e1.isEnabled());
		
		js.executeScript("window.scrollBy(0,-1000)");
		WebElement e2 = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div[1]/div[2]/div[2]/table[2]/tbody/tr/td/form/p[1]/input[1]"));
		System.out.println("e2 is enable? "+e2.isEnabled());
	}

	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}


}
