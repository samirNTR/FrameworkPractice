package testClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.HomePage_page;
import pageClasses.LogInPage;

public class LogIn extends baseClass {


	@Test(priority=1)

	public void verifyLoginPage() throws InterruptedException {
	
		LogInPage pg = new LogInPage(driver);
		HomePage_page hp= new HomePage_page(driver);
		
		pg.enterUsername(username);
		Thread.sleep(2000);
		pg.enterPassword(password);
		Thread.sleep(2000);
		pg.clickLogin();
		Thread.sleep(5000);
		
		 hp.clickOnOpenMenuButton();
		Thread.sleep(2000);
		
		hp.clickOnAboutLink();
		Thread.sleep(2000);
		
		
		
		
		
	}
	
	@Test( dependsOnMethods = "verifyLoginPage")
	
	public void verifyCurrentUrl()
	{
		
		String actPage=driver.getCurrentUrl();
		System.out.println("The current URL  "+actPage);
	   Assert.assertEquals(actPage, "https://saucelabs.com/");
		
	}
	
	@Test(dependsOnMethods = "verifyCurrentUrl")
	
		public void verifyProductsPage() throws InterruptedException
		{
		driver.navigate().back();
		
		Thread.sleep(4000);
		String actPage1=driver.getCurrentUrl();
		//String title=driver.getTitle();
		//System.out.println("Current Title   "+title);
		System.out.println("After navigate back URL  "+actPage1);
		Assert.assertEquals(actPage1, "https://www.saucedemo.com/inventory.html");
	   String title=driver.findElement(By.xpath("//span[text()='Products']")).getText();
		
	  Assert.assertEquals(title, "Products");
		
	}
	
	
	
	
		/*@Test
		
		public void verifyHomePage() throws InterruptedException
		{
			HomePage_page hp= new HomePage_page(driver);
			 hp.clickOnOpenMenuButton();
				Thread.sleep(2000);
		*/
		
		

	}

