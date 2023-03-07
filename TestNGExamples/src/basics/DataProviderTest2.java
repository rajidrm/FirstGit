package basics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest2 {
	WebDriver driver;

	
	@DataProvider(name = "testData")
	public Object[][] testData() {
		
		Object[][] details = null;
		
		try {
			FileInputStream fis = new FileInputStream("D:\\SeleniumDocuments\\udetails.xlsx");
			//Create Workbook
			Workbook w = new XSSFWorkbook(fis);
			//Create Sheet
			Sheet s = w.getSheet("Sheet1");
			//Create Row
			int totalNumberOfRows = s.getLastRowNum()+1;
			
			System.out.println("TOtal Number Of Rows : " + totalNumberOfRows);
			
			details = new Object[totalNumberOfRows][2];
			
			for(int i=0; i<totalNumberOfRows;i++)
			{
				Row r = s.getRow(i);
				
				
				details[i][0] = r.getCell(0).getStringCellValue();
				
				details[i][1] = r.getCell(1).getStringCellValue();
				
			}
			
			fis.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return details;
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
