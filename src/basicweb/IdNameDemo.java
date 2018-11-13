package basicweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/***
 * Program for searching an element by name
 * 
 * @author Juan-Luis.Vivas
 *
 */
public class IdNameDemo {

	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\gecko32\\geckodriver.exe");
		driver = new FirefoxDriver();
		String baseUrl = "https://www.google.com";
		driver.manage().window().maximize();
		driver.get(baseUrl);
		
		driver.findElement(By.id("lst-ib")).sendKeys("letskodeit");
		driver.findElement(By.name("btnK")).click();
	}

}
