package pkg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SessionNotFoundDemo {

	public static void main(String args[]) {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Srinivasan\\Desktop\\Selenium\\drivers\\chromedriver_0.exe");
		driver=new ChromeDriver();		
		driver.get("https://www.google.com");	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.close();
	}

}
