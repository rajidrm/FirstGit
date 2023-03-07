package basics;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyContactFormLinkTest 
{
	private static WebDriver driver;
	
	
	  @BeforeSuite public void createDriver() {
}
	 
	
	@BeforeTest
	public void loadURL()
	{
		
		driver.get("https://www.mycontactform.com/index.php");
		driver.manage().window().maximize();
	}
	
	@Test
	public void linkTest()
	{
		WebElement link = driver.findElement(By.linkText("How Can We Be Free* ?"));
		link.click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		String expectedtitle = "Pricing Information - myContactForm.com";
		
		String actualTitle = driver.getTitle();
		
		assertEquals(expectedtitle, actualTitle);
		
		
		System.out.println("Test Completed");
	}
	
	@AfterTest
	public void closeDriver()
	{
		driver.close();
		
	}

}
