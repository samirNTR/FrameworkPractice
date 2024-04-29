package testClasses.BufferClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TimesOfIndia {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		/*
		 * WebDriverManager.edgedriver().setup(); driver= new EdgeDriver();
		 */
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		/*
		 * driver.findElement(By.xpath("//textarea[@aria-label='Search']")).sendKeys(
		 * "Modi"); Thread.sleep(2000);
		 */
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		WebElement searchBox = driver.findElement(By.xpath("//textarea[@aria-label='Search']"));
		searchBox.sendKeys("Modi");
		Thread.sleep(5000);

		// Loop through the autosuggestions and select "Modicare" if found

		// Press down arrow to navigate to the next suggestion
		// searchBox.sendKeys(Keys.ARROW_DOWN);
		// Thread.sleep(500); // Adjust sleep time as needed

		// Get the text of the current suggestion
		List<WebElement> suggestionText = driver.findElements(By.xpath("//div[@class='wM6W7d']"));

		for (WebElement suggestion : suggestionText) {

			String text = suggestion.getText();
			Thread.sleep(2000);
			System.out.println("Autosuggestions are " + text);

		}

		driver.quit();

	}

}
