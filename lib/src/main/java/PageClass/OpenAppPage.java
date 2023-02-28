package PageClass;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenAppPage extends BasePageObject{
	
	private String pageUrl = "http://the-internet.herokuapp.com/";
	
	private By ABtest = By.xpath("//*[@id=\"content\"]/ul/li[1]/a");
	
// must define explicit costructor to use page class
	public OpenAppPage(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}
	
	public void openPage() {
		log.info("opening page: " + pageUrl);
		openUrl(pageUrl);
		log.info("Page opened!");
		
	}
	public void ClickABTest()
	{
		click(ABtest);
		log.info("A/B testing Page Opened");
	}

	
	

}
