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
	WebElement continueShoppingButton;
	
	//CheckOut Button
	@FindBy(xpath="//button[@id='checkout']")
	WebElement checkOutButton;
	
	//Remove Button
	@FindBy(xpath="//button[text()='Remove']")
	WebElement removeButton;
		
	
	
}
