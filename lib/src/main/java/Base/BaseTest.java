package Base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import PageClass.OpenAppPage;


@Listeners({Base.TestListener.class })
public class BaseTest {
	

	protected WebDriver driver;
	protected Logger log;
	
	
	protected String testSuiteName;
	protected String testName;
	protected String testMethodName;

	@Parameters({ "browser" })
	@BeforeMethod
	public void setUp(@Optional("chrome") String browser,ITestContext ctx) {
		String testName = ctx.getCurrentXmlTest().getName();
		//log = LogManager.getLogger(BaseTest.class);
		//String testName = ctx.getClass().getName();
		log = LogManager.getLogger(testName);

		BrowserDriverFactory factory = new BrowserDriverFactory(browser, log);
		driver = factory.createDriver();

		driver.manage().window().maximize();
		this.testSuiteName = ctx.getSuite().getName();
		this.testName = testName;
		// Open webpage
		
		OpenAppPage OpenURL = new OpenAppPage(driver, log);
		OpenURL.openPage();
		
		//verification
		Assert.assertEquals(OpenURL.getCurrentUrl(),"http://the-internet.herokuapp.com/","Application can not be open");
		
	}
	
	@AfterMethod
	public void tearDown() {
		log.info("Close driver");
		// Close browser
		driver.quit();
	}
	
	
	
}
