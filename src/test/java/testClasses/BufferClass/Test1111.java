package testClasses.BufferClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1111 {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		
		
		WebDriverManager.chromedriver().setup();

		driver= new ChromeDriver();


     driver.get("https://www.demoblaze.com/");
     driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		Actions act= new Actions(driver);
		WebElement s1= driver.findElement(By.xpath("//img[@class='card-img-top img-fluid']//following::a[contains(text(),'Nexus 6')]"));
		act.moveToElement(s1).click().build().perform();
		Thread.sleep(6000);
	



driver.close();
		// TODO Auto-generated method stub

	}

}
