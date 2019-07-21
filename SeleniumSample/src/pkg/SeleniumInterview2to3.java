package pkg;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import com.google.common.base.Function;

public class SeleniumInterview2to3 extends BaseClass 
{
	

	public static void main(String[] args) throws IOException {
		 WebDriver driver;
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Srinivasan\\Desktop\\Selenium\\drivers\\chromedriver.exe");
		 driver=new ChromeDriver();
		 //getProperty("chromedriverpath");
		 
		//11th.
		List<WebElement> dropdownmenus= driver.findElements(By.tagName("select"));
		System.out.println(dropdownmenus.size());
		
		//12th - Actions Class
		Actions actions= new Actions(driver);
		WebElement element=driver.findElement(By.xpath("//*[@id='dfrt']"));
		Action action=actions.moveToElement(element).click().build();
		action.perform();
		
		//13th -2 ways: SoftAssert(verify if actual and expected are same or not,however dont stop execution if a particular step fails in a testcase)
		//and HardAssert(Actual execution would be stopped if expected and actual arent matching).

		//SoftAssert
		SoftAssert softassert= new SoftAssert();
		softassert.assertEquals("Selenium", "selenummm");
		
		//HardAssert
		Assert.assertEquals("Selenium","SELENIUM");
		
		
		String parentwindow= driver.getWindowHandle();
		Set<String> childwindows= driver.getWindowHandles();
		Iterator<String> itr= childwindows.iterator();
		while(itr.hasNext())
		{
		 String childwindow=itr.next();
		  driver.switchTo().window(childwindow);
		}
		 JavascriptExecutor js=(JavascriptExecutor) driver;
		 js.executeScript("arguments[0].click();", "button");
		 
		 String application="https://www.toolsqa.com/iframe-practice-page/";
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		 driver.get(application);
		 List<WebElement> nooflinks=driver.findElements(By.tagName("a"));
		Iterator<WebElement> itr1= nooflinks.iterator();
		int counter=0;
		 while(itr1.hasNext())
		 {
			 WebElement link=itr1.next();
			 link.click();
			 boolean flgcheck=link.isEnabled();
			 if(flgcheck==false)
				 counter++;
		 }
		 
		 }

	}


