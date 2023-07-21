package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {

	public  WebDriver driver;

	public LogInPage(WebDriver driver)
	
	{

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@data-test='username']")
	WebElement username;

	@FindBy(xpath = "//input[@data-test='password'] ")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit'] ")
	WebElement clicklogin;

	public void enterUsername(String userName) {
		username.sendKeys(userName);
	}

	public void enterPassword(String passWord) {
		password.sendKeys(passWord);
	}

	public void clickLogin() {
		clicklogin.click();
	}
}
