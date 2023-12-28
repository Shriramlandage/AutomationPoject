package testing;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LiveStreamDemo {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Automation\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/");

		driver.findElement(By.xpath("//a[normalize-space()='Top Deals']")).click();

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String ParanteID = it.next();
		String ChildID = it.next();
		driver.switchTo().window(ChildID);

		// Click on column
		driver.findElement(By.xpath("//tr/th[1]")).click();

		// Capture text of all webelements into list
		List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));

		// Capture text of weblements into new (original) list
		List<String> OriginalList = elementsList.stream().map(s -> s.getText()).collect(Collectors.toList());

		// Sort on the original list of step 3 -> sorted list
		List<String> sortedList = OriginalList.stream().sorted().collect(Collectors.toList());

		// Compare Original list vs sorted List
		Assert.assertTrue(OriginalList.equals(sortedList));
		
		// Scan the name column with getText -> Beans-> print the price of the "Rice"
		List<String> price;
		do {
			List<WebElement> row = driver.findElements(By.xpath("//tr/td[1]"));

			price = row.stream().filter(s -> s.getText().contains("Tomato")).map(s -> getPriceVeggie(s))
					.collect(Collectors.toList());
			price.forEach(a -> System.out.println(a));
			if (price.size() < 1) {
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			}
		} while (price.size() < 1);

	}

	private static String getPriceVeggie(WebElement s) {
		String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return pricevalue;
	}
}
