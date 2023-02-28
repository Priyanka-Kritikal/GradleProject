package Base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserDriverFactory {
	
	public static WebDriver driver;
	private String browser;
	private Logger log;
			
	public BrowserDriverFactory(String browser, Logger log) {
		this.browser = browser.toLowerCase();
		this.log = log;
	}
	public WebDriver createDriver() {
		
	
		log.info("Create driver: " + browser);

		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		case "edgedriver":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		default:
			System.out.println("Do not know how to start: " + browser + ", starting chrome.");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		}
		
		return driver;
		
	}

}
