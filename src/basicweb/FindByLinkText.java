package basicweb;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class FindByLinkText {

	public static void main(String[] args) throws Exception {
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\gecko32\\geckodriver.exe");
		driver = new FirefoxDriver();
		//System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
		//driver = new ChromeDriver();
		//System.setProperty("webdriver.ie.driver", "C:\\selenium\\IEDriverServer.exe");
		//driver = new InternetExplorerDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //really important for avoid timeouts
		String baseURL = "https://learn.letskodeit.com/";
		driver.get(baseURL);
		
		driver.findElement(By.linkText("Login")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.partialLinkText("Pract")).click();
	}

}
