package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOut_Page extends BasePageClass {

	public CheckOut_Page(WebDriver driver) {
		super(driver);
	}

	// Continue Button
	@FindBy(xpath = "//input[@id='continue']")
	private WebElement contineButton;

	// Cancel Button
	@FindBy(xpath = "//button[@id='cancel']")
	private WebElement cancelButton;

	// TextBox->FirstName
	@FindBy(xpath = "//input[@name='firstName']")
	private WebElement firstName;

	// TextBox->LastName
	@FindBy(xpath = "//input[@name='lastName']")
	private WebElement lastName;

	// TextBox->zipPostalCode
	@FindBy(xpath = "//input[@name='postalCode']")
	WebElement postalCode;

	public void enterDetailsAtCheckOutPage(String firstname, String lastname, String postalcode)
			throws InterruptedException {

		this.firstName.sendKeys(firstname);
		Thread.sleep(2000);
		this.lastName.sendKeys(lastname);
		Thread.sleep(2000);
		this.postalCode.sendKeys(postalcode);
	}

	public void clickOnContinueButton() {
		this.contineButton.click();
	}

	public void clickOnCancelButton() {
		this.cancelButton.click();
	}

}
