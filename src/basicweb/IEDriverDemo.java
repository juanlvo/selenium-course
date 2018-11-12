package basicweb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEDriverDemo {

	public static void main(String[] args) {
		String baseUrl = "http://www.google.com";
		WebDriver driver;
		
		System.setProperty("webdriver.ie.driver", "C:\\selenium\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		
		driver.get(baseUrl);
	}

}
