package testClasses;

import org.testng.annotations.Test;
import pageClasses.LogInPage;

public class LogIn extends baseClass {

	@Test(priority=1)

	public void verifyLoginPage() throws InterruptedException {
		driver.get(url);
		LogInPage pg = new LogInPage(driver);

		
	
		pg.enterUsername(username);
		Thread.sleep(2000);
		pg.enterPassword(password);
		Thread.sleep(2000);
		pg.clickLogin();
		Thread.sleep(5000);
		
		
		

	}
}
