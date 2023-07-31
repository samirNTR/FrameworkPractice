package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage_page {
	
	public WebDriver driver;
	
	
	public HomePage_page(WebDriver driver)
	{
		
		this.driver=driver;
		
		PageFactory.initElements(driver,this);
	}

	//Three Dots
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
	
	@FindBy(xpath="//span[@class='shopping_cart_badge']")
	WebElement cartButton;
	
	@FindBy(xpath = "//select[@class='product_sort_container']")
	WebElement mainDropDown;
	
	public void clickOnOpenMenuButton()
	{
		openMenuButton.click();
	}
	

	public void clickOnAllItemsLink()
	{
		allItemsLink.click();
	}

	public void clickOnAboutLink()
	{
		aboutLink.click();
	}

	public void clickOnLogOut()
	{
		logoutLink.click();
	}

	public void clickOnResetAppStateLink()
	{
		resetAppStateLink.click();
	}
	public void clickOnShoppingCartButton()
	{
		cartButton.click();
	}
}
