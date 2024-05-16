	package testClasses;
	
	import java.util.concurrent.TimeUnit;
	
	import org.apache.logging.log4j.LogManager;
	import org.apache.logging.log4j.core.Logger;
	import org.openqa.selenium.Alert;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.PageLoadStrategy;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.edge.EdgeOptions;
	import org.openqa.selenium.remote.DesiredCapabilities;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeSuite;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Parameters;
	
	import io.github.bonigarcia.wdm.WebDriverManager;
	import utilities.ReadConfig;
	
	public class baseClass {
	
		public Logger log = (Logger) LogManager.getLogger(this.getClass());
		protected static String url, username, password;
		public WebDriver driver;
	
		@BeforeSuite
		public void setUp() {
			ReadConfig readConfig = new ReadConfig();
			readConfig.readConfigFille(); // Initialize and read properties from the config file
			url = readConfig.getBaseUrl();
			username = readConfig.getUsername();
			password = readConfig.getPassword();
			System.out.println("Url is " + url);
		}
	
		@BeforeClass
		@Parameters({"browser"})
		public void launchBrowser(String browser) {
	  if(browser.equalsIgnoreCase("chrome"))
	  {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
	  }
			else if(browser.equalsIgnoreCase("edge"))
			{
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
	  
			else
			{
				 throw new IllegalArgumentException("Unsupported browser: " + browser);
	        }
			
	
	
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
	
				driver.quit();
			}
		}
	}
	
	/*
	 * When you remove the static keyword, each instance of baseClass will have its
	 * own copy of url, username, and password. However, the setUp() method is not
	 * called for each instance; it's called only once for the entire suite.
	 * Therefore, if these variables are not static, they won't be initialized
	 * before the launchBrowser() method is called.
	 */
	
	/*
	  By using a non-static WebDriver instance, each test class manages its own
	  WebDriver object, ensuring isolation and independence between tests. This
	  typically leads to more predictable and reliable test execution.
	 */
