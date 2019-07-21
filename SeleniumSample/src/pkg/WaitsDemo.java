package pkg;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WaitsDemo {
	WebDriver driver;
	
	@Test
	public void testApp()
	{
		System.out.println("In Testmethod: testApp");
	}
	
	
	//Step1- 40 secs => ElementNotVisibleException
	//Step10
	
	//Explicitly forcing a wait for a particular situation
	@BeforeMethod
	public void setup()
	{		
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Srinivasan\\Desktop\\Selenium\\drivers\\chromedriver.exe");
		 driver=new ChromeDriver();
		 String application="https://www.google.com";
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);//Implicit wait
		 driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		 driver.get(application);
	}
	
	//wait explicitly for that much  time
	//Make something wait explicitly
	public WebElement ExplicitwaitMeth(String xpath, int time)
	{
		//By element=By.xpath(xpath);
		WebDriverWait expwait= new WebDriverWait(driver,time);
		//expwait.until(ExpectedConditions.presenceOfElementLocated(element));
		WebElement element=expwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));		
	    return element;
	}
	
	//Make Fluent wait for some condition or element
	public WebElement FluentwaitMeth(String xpath, int time)//1
	{
		Wait<WebDriver> fluentwait= new FluentWait<WebDriver>(driver)
				         .pollingEvery(time,TimeUnit.SECONDS)
				         .ignoring(NoSuchElementException.class);
		//WebElement element= fluentwait.until();
		
		WebElement element= fluentwait.until(new Function<WebDriver,WebElement>(){

			public WebElement apply(WebDriver driver) {
				return(driver.findElement(By.xpath(xpath)));
			}
		});
		
		return element;
		
	}

	@AfterMethod
	public void exitApp()
	{
		driver.quit();
	}
}
