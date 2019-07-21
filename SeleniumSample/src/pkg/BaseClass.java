package pkg;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

//Parent(BaseClass) and SubClass(Selenium java files which needs some functionality)
public class BaseClass
{
	WebDriver driver;
	static Properties prop;
	FileInputStream fip;
	String filepath=System.getProperty("user.dir")+"//src//config.properties";
	
	/* Initializes the steps for loading the config.properties file*/
	public void initialize()
	{
		try {
			fip=new FileInputStream(filepath);
			prop=new Properties();
			prop.load(fip);
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException exception caught in intialize method: "+e.getMessage());
		} catch (IOException e) {
			System.out.println("IOException exception caught in intialize method: "+e.getMessage());
		}		
	}
	
	/* Gets property from config.properties file*/
    public static String getProperty(String key)
    {
    	return prop.getProperty(key);
    }
	
    /*Base Class Constructor*/
	BaseClass()
	{
		initialize();
	}
	
	

}
