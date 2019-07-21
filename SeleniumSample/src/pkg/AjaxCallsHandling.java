package pkg;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AjaxCallsHandling {
	
	private String URL = "https://www.seleniumeasy.com/test/basic-radiobutton-demo.html";
			//"http://demo.guru99.com/test/ajax.html";
	
	WebDriver driver;
	WebDriverWait wait;
	
    public void GetScreenshot()
    {
    	File file= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    	try {
			FileUtils.moveFile(file, new File(System.getProperty("user.dir")+"//src//pkg//Screenshot.PNG"));
		} catch (IOException e) {
			System.out.println("IOException caught in method GetScrenshot");
		}
    	
    }
    
        
    
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Srinivasan\\Desktop\\Selenium\\drivers\\chromedriver.exe");
		//create chrome instance
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(URL);
	}
	
	@Test
	public void test_AjaxExample() {

	    By section = By.xpath("//*[contains(text(),'Radio Button Demo')]/parent::div");
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(section));	
	
		
		
		WebElement labelElement = driver.findElement(By.xpath("//*[contains(text(),'Radio Button Demo')]/parent::div//p[@class='radiobutton']"));
		String textBefore = labelElement.getText().trim();
		System.out.println("Textbefore: "+textBefore);
		
		//Click on the radio button
		driver.findElement(By.xpath("//*[contains(text(),'Radio Button Demo')]/parent::div//input[@value='Male']")).click();
	
		//Click on Check Button
		driver.findElement(By.xpath("//*[contains(text(),'Radio Button Demo')]/parent::div//button[@id='buttoncheck']")).click();
	
		WebElement labelElement2 = driver.findElement(By.xpath("//*[contains(text(),'Radio Button Demo')]/parent::div//p[@class='radiobutton']"));
		String textAfter = labelElement2.getText().trim();
		System.out.println("TextAfter: "+textAfter);
		GetScreenshot();
		driver.close();
	}
	
}