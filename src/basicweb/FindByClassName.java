package basicweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindByClassName {

	public static void main(String[] args) throws Exception {
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\gecko32\\geckodriver.exe");
		driver = new FirefoxDriver();
		String baseURL = "https://demostore.x-cart.com/";
		driver.manage().window().maximize();
		driver.get(baseURL);

		driver.findElement(By.className("title")).click();
		
		driver.findElement(By.className("leaf")).click(); //is going to fail because is not finding the element
	}

}
