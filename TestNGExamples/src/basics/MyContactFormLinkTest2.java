package basics;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class MyContactFormLinkTest2 {
	private static WebDriver driver;

	@BeforeSuite
	public void createDriver() {

		driver = new ChromeDriver();
		driver.get("https://www.mycontactform.com/index.php");
		driver.manage().window().maximize();
	}

	/*
	 * @BeforeTest public void loadURL() {
	 * 
	 * }
	 */

	@Test(priority = 1)
	public void linkTest() {
		WebElement link = driver.findElement(By.linkText("How Can We Be Free* ?"));
		link.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		String expectedtitle = "Pricing Information - myContactForm.com";

		String actualTitle = driver.getTitle();

		assertEquals(expectedtitle, actualTitle);

		System.out.println("Test Completed");
	}
	
	@Test(priority = 2)
	public void loginTest()
	{
		
		WebElement username = driver.findElement(By.xpath("//*[@id=\"user\"]"));
		username.sendKeys("rajirj");
		
		WebElement password = driver.findElement(By.xpath("//*[@id=\"pass\"]"));
		password.sendKeys("raji#321");
		
		WebElement login = driver.findElement(By.xpath("//*[@id=\"right_col_top\"]/form/div/input"));
		login.click();
		
		
	}
		

	@AfterSuite
	public void closeDriver() {
		driver.close();

	}
}
