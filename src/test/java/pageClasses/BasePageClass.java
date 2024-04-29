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
	private WebElement openMenuButton;
	
   //All items
	@FindBy(xpath = "//a[@id='inventory_sidebar_link']")   
	private WebElement allItemsLink;
	//About
	@FindBy(xpath = "//a[@id='about_sidebar_link']")
	private WebElement aboutLink;
	//Logout
	@FindBy(xpath = "//a[@id='logout_sidebar_link']")
	private WebElement logoutLink;
	//Reset App store
	@FindBy(xpath = "//a[@id='reset_sidebar_link']")
	private WebElement resetAppStateLink;
	


	
	
	//Cart Badge
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	private WebElement cartBadge;

	
	public void clickOnOpenMenuButton()
	{
		this.openMenuButton.click();
		
	}
	

	public void clickOnAllItemsLink()
	{
		this.allItemsLink.click();
	}

	public void clickOnAboutLink()
	{
		this.aboutLink.click();
	}

	public void clickOnLogOut()
	{
		this.logoutLink.click();
	}

	public void clickOnResetAppStore()
	{
		this.resetAppStateLink.click();
	
	}
	
	public void clickOnShoppingCartButton() 
	
	{
		this.cartBadge.click();
		
	}
	
	
	
}
