package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourCart_Page  extends BasePageClass{
	
	
	
	public YourCart_Page(WebDriver driver)
	{
		
		super(driver);
	}

	//Continue Shopping
	@FindBy(xpath="//button[@id='continue-shopping']")
	private WebElement continueShoppingButton;
	
	//CheckOut Button
	@FindBy(xpath="//button[@id='checkout']")
	private WebElement checkOutButton;
	
	//Remove Button
	@FindBy(xpath="//button[text()='Remove']")
	private WebElement removeButton;
	
	
	
	public void clickOnContinueShopping()
	{
		this.continueShoppingButton.click();
	}
	
	
	public void clickOnChecOutButton()
	{
		this.checkOutButton.click();
	}
	
	public void clickOnRemoveButton()
	{
		this.removeButton.click();
	}
}
