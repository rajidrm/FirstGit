package basics;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParameterizedTest 
{
	
	@DataProvider(name="testData")
	public Object[][] testData()
	{
		return new Object[][] {{"rajirj","raji#321"},{"sathish123","sathish#2212"},{"java123","java#123"}};
	}
	
	@Test(dataProvider="testData")
	public void loginTest(String username, String password )
	{
		System.out.println("Username : " + username);
		System.out.println("Password : " + password);
	}

}
