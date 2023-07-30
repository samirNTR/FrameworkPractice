package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public WebDriver driver;
	
	
	public HomePage(WebDriver driver)
	{
		
		this.driver=driver;
		
		PageFactory.initElements(driver,this);
	}

	
	@FindBy(xpath="//button[@id='react-burger-menu-btn']")
	WebElement openMenuButton;
	
	@FindBy(xpath = "//a[@id='inventory_sidebar_link']")
	WebElement allItemsLink;
	
	@FindBy(xpath = "//a[@id='about_sidebar_link']")
	WebElement aboutLink;
	
	@FindBy(xpath = "//a[@id='logout_sidebar_link']")
	WebElement logoutLink;
	
	@FindBy(xpath = "//a[@id='reset_sidebar_link']")
	WebElement resetAppStateLink;
	
	
	
	
	@FindBy(xpath = "//select[@class='product_sort_container']")
	WebElement mainDropDown;
	
	
	
}
