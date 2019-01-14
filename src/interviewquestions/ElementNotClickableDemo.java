package interviewquestions;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/***
 * Section 24 Lecture 136
 * Element not clickable example
 * 
 * @author Juan-Luis.Vivas
 *
 */
class ElementNotClickableDemo {
	private WebDriver driver;
	private String baseUrl;
	private JavascriptExecutor js;
	
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		baseUrl = "https://www.freecrm.com/index.html";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test
	void test() {
		driver.get(baseUrl);
		
		driver.findElement(By.name("username")).sendKeys("testing");;
		//WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
		//loginButton.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 3);
		//WebElement loginButton = (WebElement) wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@value='Login']")));
		//loginButton.click();
		
		//in this way works for me
		/*boolean invisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("preloader")));
		
		if (invisible) {
			WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
			loginButton.click();
		}*/
		
		WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
		js.executeScript("arguments[0].click()", loginButton);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
