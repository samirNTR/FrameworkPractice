package testClasses;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageClasses.LogIn_Page;

public class Parameterize_LogIn extends baseClass {
	public LogIn_Page loginPage;

	@DataProvider(name = "userCredentials")
	public Object[][] getUserCredentials() 
	{
		return new Object[][] { 
			
			{ "standard_user", "secret_sauce" },

				{ "problem_user", "secret_sauce" }, { "performance_glitch_user", "secret_sauce" },
				{ "error_user", "secret_sauce" }, { "visual_user", "secret_sauce" }

		};
	}

	@Test(dataProvider = "userCredentials")                                   //IllegalArgumentException if change the dataProvider name to something diffrent
	public void loginTest(String username, String password) throws InterruptedException {
		// Perform login with the provided username-password combination
		loginPage = new LogIn_Page(driver);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();

		// Add assertions or other actions as needed
		Thread.sleep(3000);
		loginPage.clickOnOpenMenuButton();
		loginPage.clickOnLogOut();
		// Logout (if applicable)
		Thread.sleep(3000);

	}

}
