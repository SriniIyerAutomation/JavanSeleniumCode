package pkg;

import java.awt.AWTException;
import java.awt.Robot;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CrackSeleniumInterviewPart2 {

public static void main(String args[]) throws ClassNotFoundException, SQLException
{
	 WebDriver driver;
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Srinivasan\\Desktop\\Selenium\\drivers\\chromedriver.exe");
	 driver=new ChromeDriver();
	 String application="https://www.toolsqa.com/iframe-practice-page/";
	 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	 driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	 driver.manage().window().maximize();
	 driver.get(application);
	 
	 driver.switchTo().frame(1);//index
	 driver.switchTo().frame("iframe1");//name of frame
	 WebElement frame1=driver.findElement(By.xpath("//iframe[@name='iframe1']"));//element representing the frame
	 driver.switchTo().frame(frame1);
	 
	 //JDBC Connection que
	 String connectionstring="jdbc:oracle:thin:@localhost:1521:xe";
	 String username="username";
	 String password="password";
	 Connection conn=null;
	 Statement stmt=null;
	 ResultSet rs=null;
	 
	 //Step1: Loading the appropriate driver
	 Class.forName("oracle.jdbc.driver.OracleDriver");//load the driver for OracleDB
	 //Step2: Creating a connection using connection string, username and password
	 conn=DriverManager.getConnection(connectionstring, username, password);
	 //Step3: Create Statement
	 stmt= conn.createStatement();
	 //Step4: Execute the query and store into ResultSet
	 rs=stmt.executeQuery("select * from emp");
	 //Step5: Iterate over the resultset and print the output or retrieve the output from the table
	 while(rs.next())
	 {
		 System.out.println("Column1: "+rs.getString(0)+"Column2: "+rs.getInt(2)+"  Column3: "+rs.getString("Name"));
	 }
}

}
