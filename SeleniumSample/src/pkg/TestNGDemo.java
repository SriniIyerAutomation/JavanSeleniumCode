package pkg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGDemo {
	WebDriver driver=null;
	
	public TestNGDemo() {
		
	}

	@Test(priority=0,description="TestLogin Testcase",groups= {"sanity","functional"})//TestMethod
	public void TestLogin()
	{
		System.out.println("In TestLogin");		
		
	}
	
	@Test(priority=1,description="TestHomePage Testcase",groups= {"E2E","Modular"}) //TestMethod of TestNG
	public void TestHomePage()
	{
		System.out.println("In TestHomePage");
	}
	
	@BeforeMethod(groups= {"sanity","functional","E2E","Modular"})
	public void setup()
	{
		System.out.println("Before Method");	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Srinivasan\\Desktop\\Selenium\\drivers\\chromedriver_0.exe");
		driver=new ChromeDriver();		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://www.google.com");	
		driver.manage().window().maximize();		
	}
	
	@AfterMethod(groups= {"sanity","functional","E2E","Modular"})//After TestMethod
	public void exitApp()
	{
		System.out.println("After Method");
		driver.quit();
	}
	
	@BeforeTest(groups= {"sanity","functional","E2E","Modular"})//Before TestCase
	public void BeforeApp()
	{
		System.out.println("Before Test");		
	}
}
	
