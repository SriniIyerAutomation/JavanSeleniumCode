package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {

	WebDriver driver;
	By userid=By.className("class1");
	By passwd=By.id("pass");
	
	
	@FindBy(id="id1")
	WebElement userid1;
	
	@FindBy(xpath="//*[@id='pass1']")
	WebElement passwd1;
	
	
	public SignUpPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void provideUserIdinfo(String UserIdVal) 
	{
		driver.findElement(userid).sendKeys(UserIdVal);
	}

	public void providePasswdinfo(String PasswdVal) 
	{
		driver.findElement(passwd).sendKeys(PasswdVal);
	}
}
