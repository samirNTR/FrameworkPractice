package testClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ReadConfig;

public class baseClass  {

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
    }
	@BeforeClass
	public void launchBrowser() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		System.out.println("I am in base class");
	}

	@AfterClass
	public void closeBrowser() {
System.out.println("Im in base class 2");
		driver.close();
		driver.quit();

	}
}