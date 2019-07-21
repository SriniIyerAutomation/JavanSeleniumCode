package pkg;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//Xpath Axes: sibling, ancestor, following, preceding,child, preceding-sibling, following-sibling, parent, self, descendant
//https://www.seleniumeasy.com/selenium-tutorials
//https://money.rediff.com/gainers/bse/daily/groupa
//String str="C:\\Users\\Srinivasan\\Desktop\\Selenium\\drivers\\chromedriver.exe";

//child following-sibling,descendant

public class XpathAxesDemo
{
	
 public static void main(String args[])	
 {
	WebDriver driver;
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Srinivasan\\Desktop\\Selenium\\drivers\\chromedriver.exe");
	driver=new ChromeDriver();
	String application="https://money.rediff.com/gainers/bse/daily/groupa";	
	
	driver.get(application);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
	
	System.out.println("self example");
	WebElement sbilife=driver.findElement(By.xpath("//*[contains(text(),'SBI Life Insurance')]/self::a"));
	System.out.println("SBILife Insurance self getText: "+sbilife.getText());
	
	System.out.println("parent example");
	WebElement sbicell=driver.findElement(By.xpath("//*[contains(text(),'SBI Life Insurance')]/parent::td"));
	System.out.println("SBILife Insurance parent getText: "+sbicell.getText());
	
	System.out.println("ancestor example");
	WebElement sbiancestor=driver.findElement(By.xpath("//*[contains(text(),'SBI Life Insurance')]/parent::td/ancestor::tr"));
	System.out.println("SBILife Insurance ancestor getText: "+sbicell.getText());

	System.out.println("preceding-sibling example");
	List<WebElement> sbiprecedingsibling=driver.findElements(By.xpath("//*[contains(text(),'SBI Life Insurance')]/parent::td/ancestor::tr/preceding-sibling::tr"));
	Iterator<WebElement> itr = sbiprecedingsibling.iterator();
	while(itr.hasNext())
	{
		WebElement element= itr.next();
		System.out.println("Element getText: "+element.getText());		
	}
	System.out.println("following-sibling example");	
	List<WebElement> centralbankfollowingsib=driver.findElements(By.xpath("//*[contains(text(),'Central Bank')]/parent::td/following-sibling::td"));
	
	System.out.println("child example");
	List<WebElement> centralbankChildren=driver.findElements(By.xpath("//*[contains(text(),'Central Bank')]/parent::td/parent::tr/child::td"));
	
	
	List<WebElement> centralbankdescendants=driver.findElements(By.xpath("//*[contains(text(),'Central Bank')]/parent::td/parent::tr/descendant::td"));
 }
 
}