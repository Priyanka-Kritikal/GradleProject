package TestClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.TestUtilities;
import PageClass.OpenAppPage;

public class OpenAppTest extends TestUtilities{
	
	@Test(priority =1)//(dataProvider = "csvReader" , dataProviderClass= CsvDataProviders.class)
	
	public void OpenApp()
	{
		OpenAppPage ClickOnAB = new OpenAppPage(driver, log);
		ClickOnAB.ClickABTest();
		takeScreenshot("A/B TestPage");
		System.out.print("gittest");
		Assert.assertEquals(ClickOnAB.getCurrentUrl(), "http://the-internet.herokuapp.com/abtest");
		
	}

}
