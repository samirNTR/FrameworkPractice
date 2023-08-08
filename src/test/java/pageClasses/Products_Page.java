package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Products_Page extends BasePageClass {
	
	public WebDriver driver;
	
	
	public Products_Page(WebDriver driver)
	{
		super(driver);
	}

	

	
	@FindBy(xpath = "//select[@class='product_sort_container']")
	WebElement dropdownElement;
	
	public void selectOptionByValue(String value) {
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue(value);

	}
	
}
