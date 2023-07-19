package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Enter login credentials
		WebElement username = driver.findElement(By.xpath(" //input[@data-test='username']"));
		username.sendKeys("standard_user");
		WebElement password = driver.findElement(By.xpath("//input[@data-test='password'] "));
		password.sendKeys("secret_sauce");

		//click login
		WebElement loginbtn = driver.findElement(By.xpath("//input[@type='submit']"));
		loginbtn.click();

		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[@id='about_sidebar_link']")).click();
		Thread.sleep(3000);

		String actualPage = driver.getCurrentUrl();

		//Page Validation
		System.out.println("Current URL is:-" + actualPage);

		if (actualPage.equalsIgnoreCase("https://saucelabs.com/")) {
			System.out.println("Test case passed for landing page");
		}

		else {

			System.out.println(" Test case Failed");
		}

		Thread.sleep(2000);
		driver.navigate().back();

		WebElement wb = driver.findElement(By.xpath(" //select[@class='product_sort_container'] "));
		Select sel = new Select(wb);
		sel.selectByValue("hilo");

		WebElement addToCart = driver
				.findElement((By.xpath("//button[@data-test='add-to-cart-sauce-labs-fleece-jacket']")));
		addToCart.click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).click();

		String actualCartPage = driver.getCurrentUrl();
		Thread.sleep(5000);
		System.out.println(actualCartPage);

		if (actualCartPage.equals("https://www.saucedemo.com/cart.html")) {

			System.out.println("Test case passed for actual cart page");
		} else {
			System.out.println("Test failed");
		}

		//Clickin on check out button
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@class='btn btn_action btn_medium checkout_button']")).click();

		String currentPageTitle = driver.findElement(By.xpath("//span[@class='title']")).getText();
		System.out.println("The current page title at checkout " +currentPageTitle);
		if (currentPageTitle.equals("Checkout: Your Information")) {
			System.out.println("Test case is passed");
		}

		else {

			System.out.println(" Test case Failed");
		}
		
		driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("Samir");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("Jena");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("751003");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		Thread.sleep(6000);
		 String checkOutOverview=driver.findElement(By.xpath("//span[@class='title']")).getText();
		 System.out.println("Print current tittle " +checkOutOverview);
		 
		 if(checkOutOverview.equals("Checkout: Overview"))
		 {
			 System.out.println("Test case passed");
		 }
		
		 else
		 {
			 System.out.println("Test case failed");
		 }
		 
		String PriceDispalyed= driver.findElement(By.xpath("//div[@class='summary_info_label summary_total_label']")).getText();
		

		System.out.println("Dispalyed price is  "+PriceDispalyed);
		
		if(PriceDispalyed.equals("Total: $53.99"))
		{
			System.out.println("Test passed");
			
		}
		
		else
		{
			
			System.out.println("Test failed");
		}
		
		Thread.sleep(4000);
		driver.close();
		
		driver.quit();

	}

}
