package testClasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pageClasses.LogIn_Page;
import pageClasses.Products_Page;

public class LogIn extends baseClass {

	public LogIn_Page pg;
	public Products_Page hp;

	@Test(priority = 1) // 1...............................................
	public void verifyLoginPage() throws InterruptedException {

		pg = new LogIn_Page(driver);
		hp = new Products_Page(driver);

		pg.enterUsername(username);
		Thread.sleep(2000);
		log.info("Username Entered"); // Logger1
		pg.enterPassword(password);
		Thread.sleep(2000);
		log.info("Password enterd"); // Logger 2

		pg.clickLogin();
		Thread.sleep(5000);

	}

	@Test(dependsOnMethods = "verifyLoginPage") // 2....................................
	public void verifyCurrentUrl() throws InterruptedException {

		hp.clickOnOpenMenuButton();
		Thread.sleep(2000);

		hp.clickOnAboutLink();
		Thread.sleep(2000);
		String actPage = driver.getCurrentUrl();
		// Reporter.log("Actual Page is " + actPage);
		Assert.assertEquals(actPage, "https://saucelabs.com/");
		log.info("Assertion passed");
	}

	@Test(dependsOnMethods = "verifyCurrentUrl")
	public void verifyProductsPage() throws InterruptedException {
		driver.navigate().back();
		Thread.sleep(4000);
		String actPage1 = driver.getCurrentUrl();
		Reporter.log("After navigate back URL " + actPage1);
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

		double highestPrice = Double.MIN_VALUE;

		double lowestPrice = Double.MAX_VALUE;
		int highestPriceIndex = 0;

		for (int i = 0; i < list.size(); i++) {
			double newPrice = list.get(i);
			if (newPrice > highestPrice) {
				highestPrice = newPrice;
				highestPriceIndex = i;
			}
		}

		for (int i = 0; i < list.size(); i++) {
			double newPrice = list.get(i);
			if (newPrice < lowestPrice) {
				lowestPrice = newPrice;

			}

		}

		Collections.sort(list);
		
		System.out.println("Price range "+list);
		
		
		addToCartButtons.get(highestPriceIndex).click();
		hp.clickOnShoppingCartButton();
		Thread.sleep(5000);
		System.out.println("Highest price is:- " + highestPrice);
		System.out.println("Lowest price is:- " + lowestPrice);
		System.out.println("Current page " + driver.getCurrentUrl());

		String actTitle = driver.findElement(By.xpath("//span[text()='Your Cart']")).getText();
		System.out.println(actTitle);
		Assert.assertEquals(actTitle, "Your Cart12333", "I am in Your Cart Page");

	}
}
