package basicweb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriveDemo {

	public static void main(String[] args) {
		
		String baseUrl = "http://www.google.com";
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get(baseUrl);
	}

}
