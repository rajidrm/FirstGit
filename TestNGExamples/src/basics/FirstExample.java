package basics;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstExample 
{
	
	@BeforeTest
	public void loadDriver()
	{
		System.out.println("Before Test");
	}
	
	@Test
	public void testRun()
	{
		System.out.println("Test");
	}
	
	@AfterTest
	public void closeDriver()
	{
		System.out.println("After Test");
	}

}
