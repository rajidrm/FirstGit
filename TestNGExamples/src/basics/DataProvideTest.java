package basics;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvideTest {
	WebDriver driver;

	int num=0;
	

	@BeforeClass
	public void loadUrl() {
		

	}

	@DataProvider(name = "testData")
	public Object[][] testData() {
		return new Object[][] { { "rajirj", "raji#321" }, { "sathish123", "sathish#321" }, { "satha123", "satha#123" } };
	}

	@Test(dataProvider = "testData")
	public void loginTest(String username, String password) {
		driver = new ChromeDriver();
		driver.get("https://www.mycontactform.com");
		//driver.manage().window().maximize();

		WebElement username1 = driver.findElement(By.xpath("//*[@id=\"user\"]"));
		username1.sendKeys(username);

		WebElement password1 = driver.findElement(By.xpath("//*[@id=\"pass\"]"));
		password1.sendKeys(password);

		WebElement login = driver.findElement(By.xpath("//*[@id=\"right_col_top\"]/form/div/input"));
		login.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		try {

			TakesScreenshot screenShot = ((TakesScreenshot) driver);

			File src = screenShot.getScreenshotAs(OutputType.FILE);

			String path = "D:/ScreenShots/" + username + ".jpg";
			System.out.println(path);
			File dest = new File(path);

			FileUtils.copyFile(src, dest);

		} catch (Exception e) {
			System.err.println(e);
		}
		finally
		{
			
			driver.close();
		}

	}

	

}
