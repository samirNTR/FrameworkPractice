package testClasses;

import java.util.ArrayList;
import java.util.List;

import org.apache.hc.core5.http2.hpack.HPackDecoder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pageClasses.HomePage_page;
import pageClasses.LogInPage;

public class LogIn extends baseClass {
	LogInPage pg;
	HomePage_page hp;
	
	@Test(priority=1)

	public void verifyLoginPage() throws InterruptedException {

		 pg = new LogInPage(driver);
		 hp = new HomePage_page(driver);

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

	@Test(dependsOnMethods = "verifyLoginPage")

	public void verifyCurrentUrl() {

		String actPage = driver.getCurrentUrl();
	   Reporter.log("Actual Page is "+actPage);
		Assert.assertEquals(actPage, "https://saucelabs.com/");

	}

	@Test(dependsOnMethods = "verifyCurrentUrl")

	public void verifyProductsPage() throws InterruptedException {
		driver.navigate().back();

		Thread.sleep(4000);
		String actPage1 = driver.getCurrentUrl();
		// String title=driver.getTitle();
		// System.out.println("Current Title "+title);
		Reporter.log("After navigate back URL " +actPage1);
		Assert.assertEquals(actPage1, "https://www.saucedemo.com/inventory.html");
		String title = driver.findElement(By.xpath("//span[text()='Products']")).getText();

		Assert.assertEquals(title, "Products");

	}

	@Test(dependsOnMethods = "verifyProductsPage")
	
	public void verifyPriceDynamically() throws InterruptedException {
	    List<WebElement> allPrices = driver.findElements(By.className("inventory_item_price"));
	    List<Double> list = new ArrayList<Double>();
	    List<WebElement> addToCartButtons = driver.findElements(By.xpath("//button[text()='Add to cart']"));

	    for (WebElement allPrices1 : allPrices) {
	        String pricetext = allPrices1.getText().replaceAll("[^0-9.0]", " ");
	        double priceValue = Double.parseDouble(pricetext);
	        list.add(priceValue);
	    }

	    double highestPrice = 0.0;
	 
	    int highestPriceIndex = 0;

	    for (int i = 0; i < list.size(); i++)
	    {
	        double newPrice = list.get(i);
	        if (newPrice > highestPrice) {
	            highestPrice = newPrice;
	            highestPriceIndex = i;
	        }
	    }

	    // Click the "Add to Cart" button corresponding to the highest price item
	    addToCartButtons.get(highestPriceIndex).click();
	    
	   hp.clickOnShoppingCartButton();
	    
	    
	    Thread.sleep(5000);
        System.out.println("Highest price is:- "+highestPrice );
		System.out.println("Current page  " +driver.getCurrentUrl());
		
	    // Perform "add to cart" or "click" operation on the element with the highest price
	  
	    
	    }
	}

		
		
	
	/*
	 * @Test
	 * 
	 * public void verifyHomePage() throws InterruptedException { HomePage_page hp=
	 * new HomePage_page(driver); hp.clickOnOpenMenuButton(); Thread.sleep(2000);
	 */


