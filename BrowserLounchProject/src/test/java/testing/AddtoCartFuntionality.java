package testing;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AddtoCartFuntionality {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Automation\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String[] itemsNeeded = { "Cucumber", "Brocolli", "Tomato", "Grapes" };

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++) {

			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();

			// format it to get actul vagetable name
			// check whether name you extracredis present in array or not
			// Convert array into array list for easy search

			List itemsNeededList = Arrays.asList(itemsNeeded);
			int j = 0;
			if (itemsNeededList.contains(formattedName)) {
				j++;
				// Click on Add to cart Button.
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				if (j == 4) {
					break;
				}
			}
		}
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.cssSelector("input[placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[normalize-space()='Apply']")).click();
		System.out.println(driver.findElement(By.xpath("//span[@class='promoInfo']")).getText());
		driver.findElement(By.xpath("//button[normalize-space()='Place Order']")).click();

		WebElement dropdownElement = driver.findElement(By.xpath("//div[@class='wrapperTwo']//div//select"));
		Select dropdown = new Select(dropdownElement);
		dropdown.selectByVisibleText("India");
		driver.findElement(By.className("chkAgree")).click();
		driver.findElement(By.cssSelector("div[class='wrapperTwo'] button")).click();
		WebElement thankYouMessageElement = driver
				.findElement(By.xpath("//span[contains(text(),'Thank you, your order has been placed successfully')]"));

		// Check if the "Thank you" message is displayed
		if (thankYouMessageElement.isDisplayed()) {
			System.out.println("Thank you message is displayed!");
		} else {
			System.out.println("Thank you message is not displayed!");
		}
		driver.close();
	}
}
