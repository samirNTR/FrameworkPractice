package testClasses.BufferClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo1 {

//Add all items to cart one by one and remove the same on carts page
		
		
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
		// TODO Auto-generated method stub
			Thread.sleep(2000);
			
			List<WebElement> addToCartButtons = driver.findElements(By.xpath("//button[text()='Add to cart']"));

			for (WebElement button : addToCartButtons) {
			    button.click();
			    try {
			        Thread.sleep(2000); // Wait for 2 seconds before clicking the next button
			    } catch (InterruptedException e) {
			        e.printStackTrace();
			    }
			}

          driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
          Thread.sleep(2000);
          

			List<WebElement> removeButton = driver.findElements(By.xpath("//button[text()='Remove']"));

			for (WebElement button : removeButton) {
			    button.click();
			    try {
			        Thread.sleep(2000); // Wait for 2 seconds before clicking the next button
			    } catch (InterruptedException e) {
			        e.printStackTrace();
			    }
			}
          
			
			
	}

}
