package pkg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CollectionsinSelenium {
	
	public static WebDriver driver;
	
	//Collections: ArrayList, Set, HashMap
	
	public static void setup(String application)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Srinivasan\\Desktop\\Selenium\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();//FireFoxDriver()
		driver.get(application);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
	}

	public static void ElementListUsage(String xpathval)
	{
		System.out.println("List Usage example: ");
		List<WebElement> uplprecedingsibling=driver.findElements(By.xpath(xpathval));
		//List<WebElement> element1= new ArrayList<WebElement>();
		
		Iterator<WebElement> itr = uplprecedingsibling.iterator();
		String value="";
		int i=1;
		HashMap<String,String> ElementValues = new HashMap<String,String>();
		while(itr.hasNext())
		{
			WebElement element= itr.next();//return the next element(td)
			value=element.getText();//give getText or value of td
			System.out.println("Element getText: "+value);
			ElementValues.put("Element"+i, value);//store data into HashMap
			i++;
		}
		dispHashMapValues(ElementValues);
	}
	
	public static void DropdownList(String xpath)
	{
		System.out.println("Dropdown elements list Usage example: ");
		List<WebElement> Dropdownlist=driver.findElements(By.xpath(xpath));
		Iterator<WebElement> itr = Dropdownlist.iterator();
		
		int i=1;	
		String value="";	
		while(itr.hasNext())
		{
			WebElement element= itr.next();//individual element
			value=element.getText();//individual value of each element
			System.out.println("Element getText: "+value);			
		}
		
	}
	
	public static void SetUsage()
	{
		System.out.println("Set Usage example: ");
		System.out.println("Window handle example");
        String parentWindowHandle=driver.getWindowHandle();//Unique window identifier
        System.out.println("Parent Window Handle: "+parentWindowHandle);
        
        Set<String> childwindowHandles=driver.getWindowHandles();//Set of String
		String childwindow="";
        Iterator<String> itr=childwindowHandles.iterator();
        while(itr.hasNext())
        {
        	childwindow=itr.next();//get next value //next window
        	System.out.println("Child Window Handle: "+childwindow);
        	if(!parentWindowHandle.equals(childwindow))
        	{
        		driver.switchTo().window(childwindow);
        		System.out.println("Child Window title: "+driver.getTitle());
        		driver.close();
        	}     
        	else
        		System.out.println("This is Parent window, its title: "+driver.getTitle()); 
        	
        }
        driver.switchTo().window(parentWindowHandle);
        System.out.println("Window title: "+driver.getTitle());
	}
	
	public static void dispHashMapValues(HashMap<String,String> elementValues)
	{
       Set<Entry<String, String>> elementsset= elementValues.entrySet();
	   Iterator<Entry<String,String>> Itr= elementsset.iterator();	
       while(Itr.hasNext())
       {
    	  Entry<String,String> entry= Itr.next();
    	  System.out.println("Key: "+entry.getKey()+" Value: "+entry.getValue());    	  
       }       
	}
	
	public static void quitDriver()
	{
		driver.quit();
	}
	
	//https://www.naukri.com
	public static void main(String[] args) {
		String application="https://money.rediff.com/gainers/bse/daily/groupa";	
		String application2="https://www.naukri.com";
		String application3="https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html";
		setup(application);		
		String xpathList="//*[contains(text(),'UPL')]/parent::td/ancestor::tr/preceding-sibling::tr";
		String xpdropdownList="//*[@id='select-demo']";
		
		//for storing values in an ArrayList of elements
		ElementListUsage(xpathList);
		quitDriver();
				
		//For List of Values Usage: Store in an ArrayList
	/*	setup(application3);
		DropdownList(xpdropdownList);
		quitDriver(); 
	*/			
		//For Set Usage: Store in a Set.
	/*	setup(application2);
		SetUsage();
		quitDriver();
	*/	
	}

}
