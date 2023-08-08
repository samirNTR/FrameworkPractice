package testClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageClasses.Products_Page;
import pageClasses.LogIn_Page;
import utilities.ReadConfig;

public class baseClass {

	ReadConfig readConfig = new ReadConfig();
	public String url;
	public String username;
	public String password;
	public static WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		readConfig.readConfigFille(); // Initialize and read properties from the config file
		url = readConfig.getBaseUrl();
		username = readConfig.getUsername();
		password = readConfig.getPassword();
		System.out.println("Url is " + url);
	}

	@BeforeClass
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		/*
		 * public void launchBrowser(String browser) { if
		 * (browser.equalsIgnoreCase("Chrome")) {
		 * WebDriverManager.chromedriver().setup(); driver = new ChromeDriver(); } else
		 * if (browser.equalsIgnoreCase("Edge")) {
		 * WebDriverManager.edgedriver().setup(); driver = new EdgeDriver(); } else {
		 * throw new IllegalArgumentException("Invalid browser value provided."); }
		 */

		if (url != null) {
			driver.get(url);
		} else {
			throw new RuntimeException("URL is not specified in the properties file.");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		System.out.println("I am in base class");
	}

@AfterClass
	public void closeBrowser() {
	
		if (driver != null) {
			driver.close();
			driver.quit();
		}
	}
}
