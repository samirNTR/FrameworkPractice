package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BasePageClass {
	
	

	public  WebDriver driver;

	public  BasePageClass (WebDriver driver)
	
	{

		this.driver = driver;

		PageFactory.initElements(driver,this);

	}
	

	//Three Dots elements
	@FindBy(xpath="//button[@id='react-burger-menu-btn']")
	WebElement openMenuButton;
   //All items
	@FindBy(xpath = "//a[@id='inventory_sidebar_link']")   
	WebElement allItemsLink;
	//About
	@FindBy(xpath = "//a[@id='about_sidebar_link']")
	WebElement aboutLink;
	//Logout
	@FindBy(xpath = "//a[@id='logout_sidebar_link']")
	WebElement logoutLink;
	//Reset App store
	@FindBy(xpath = "//a[@id='reset_sidebar_link']")
	WebElement resetAppStateLink;
	


	
	
	//Cart Badge
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	WebElement cartBadge;

	
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

	public void clickOnResetAppStore()
	{
		resetAppStateLink.click();
	
	}
	
	public void clickOnShoppingCartButton() 
	
	{
		cartBadge.click();
		
	}
	
	
	
}
