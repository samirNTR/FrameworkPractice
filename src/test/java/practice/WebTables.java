package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTables {

	static WebDriver driver;

	public static boolean getRowColname(String name) {

		int row = driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
		int cols = driver.findElements(By.xpath("//table[@id='customers']//tr//th")).size();

		System.out.println("The number of rows are " + row + "\nThe number of coloumns are " + cols);

		boolean flag = false;
		for (int i = 1; i < row; i++) {

			for (int j = 1; j <= cols; j++) {

				String value = driver
						.findElement(By.xpath("//table[@id=\"customers\"]/tbody/tr[" + (i + 1) + "]/td[" + j + "] "))
						.getText().trim();

				if (value.equalsIgnoreCase(name.trim()) || value.contains(name.trim())) {
					flag = true;
					System.out.print(i + ":" + j);

					break;
				}
			}
		}

		if (flag) {
			return true;
		}

		return flag;
	}

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/html/html_tables.asp");

		System.out.println("\n" + getRowColname("     Italy"));

		driver.quit();

	}

	// System.out.println("The values are "+value1);

}
