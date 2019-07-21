package pkg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG1 extends BaseClass
{
	static WebDriver driver=null;

	/*This methods launches the chrome browser   */
	@BeforeMethod(groups= {"sanity","functional","E2E","Modular"})
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver",getProperty("chromedriverpath"));
		driver=new ChromeDriver();
		//driver.get(getProperty("application"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}

	
	@AfterMethod(groups= {"sanity","functional","E2E","Modular"})
	public void quitWin()
	{
		driver.quit();
	}
	
	public TestNG1() 
	{
		 super();//cannot refer to this or super while explicitly invoking a constructor
         System.out.println("TestNG1 Constructor");	 
	}

	//@TestMethod using DataProvider method
	@Test(priority=0,description="Sample TestNG Testcase",groups= {"sanity","functional","E2E","Modular"})//,dataProvider="Providedata",)
	@Parameters({"Username","Searchkey"})
	public void Testsample(String username, String searchkey)
	{
		System.out.println("This is Testsample testcase method");
		driver.get(getProperty("application"));
		System.out.println("Loggedin User: "+username+" SearchKey: "+searchkey);
		driver.findElement(By.xpath("//*[@aria-label='Search']")).sendKeys(searchkey);
		driver.findElement(By.xpath("//*[@class='erkvQe']/li[1]//div[@class='sbtc']")).click();
		System.out.println("Page Title: "+driver.getTitle());
	}
	
	@Test(enabled=false,description="Test2")//Testmethod
	public void Test2()
	{
		
	}
	//DataProvider method
	@DataProvider(name="Providedata")
	public Object[][] providedata()
	{
		Object[][] values= {{"Srini","Selenium"},{"Srinivas","Java"}};
  	    return values;	
  	    
  	    //get data from excel using apache poi and store it in 2-d object array as seen above
	}
	
	
	
	
	
}
