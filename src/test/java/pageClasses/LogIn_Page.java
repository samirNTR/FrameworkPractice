package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogIn_Page extends BasePageClass {

	public LogIn_Page(WebDriver driver)

	{
		super(driver);

	}

	@FindBy(xpath = "//input[@data-test='username']")
	private WebElement username;

	@FindBy(xpath = "//input[@data-test='password'] ")
	private WebElement password;

	@FindBy(xpath = "//input[@type='submit'] ")
	private WebElement clicklogin;

	public void enterUsername(String userName) {
		this.username.sendKeys(userName);
	}

	public void enterPassword(String passWord) {
		this.password.sendKeys(passWord);
	}

	public void clickLogin() {
		this.clicklogin.click();
	}
}
